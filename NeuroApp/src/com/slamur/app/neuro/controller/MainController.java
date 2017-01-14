package com.slamur.app.neuro.controller;

import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.app.neuro.domain.dictionary.DictionaryModel;
import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.app.neuro.domain.parameter.ParameterEntity;
import com.slamur.app.neuro.domain.parameter.ParameterModel;
import com.slamur.app.neuro.domain.query.QueryEntity;
import com.slamur.app.neuro.domain.query.QueryModel;
import com.slamur.app.neuro.domain.query.QueryParameterEntity;
import com.slamur.app.neuro.domain.query.QueryParameterModel;
import com.slamur.app.neuro.service.*;
import com.slamur.app.neuro.session.SessionStorage;
import com.slamur.lib.domain.DomainEntity;
import com.slamur.lib.domain.DomainNamedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@Transactional
public class MainController {

    private final DictionaryService dictionaryService;

    private final DictionaryTypeService dictionaryTypeService;

    private final ParameterService parameterService;

    private final PrimitiveTypeService primitiveTypeService;

    private final QueryService queryService;

    private final QueryParameterService queryParameterService;

    private final SessionStorage sessionStorage;

    @Autowired
    public MainController(
            DictionaryService dictionaryService,
            DictionaryTypeService dictionaryTypeService,
            ParameterService parameterService,
            PrimitiveTypeService primitiveTypeService,
            QueryService queryService,
            QueryParameterService queryParameterService,
            SessionStorage sessionStorage
    ) {
        this.dictionaryService = dictionaryService;
        this.dictionaryTypeService = dictionaryTypeService;
        this.parameterService = parameterService;
        this.primitiveTypeService = primitiveTypeService;
        this.queryService = queryService;
        this.queryParameterService = queryParameterService;
        this.sessionStorage = sessionStorage;
    }

    private void initSession() {
        if (sessionStorage.getDictionaryTypes() == null) {
            sessionStorage.setDictionaryTypes(
                    dictionaryTypeService.getAll()
            );
        }

        if (sessionStorage.getPrimitiveTypes() == null) {
            sessionStorage.setPrimitiveTypes(
                    primitiveTypeService.getAll()
            );
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        initSession();

        Map<DictionaryTypeEntity, List<DictionaryEntity>> dictionariesByTypes = new LinkedHashMap<>();
        for (DictionaryTypeEntity dictionaryType : sessionStorage.getDictionaryTypes()) {
            dictionariesByTypes.put(
                    dictionaryType,
                    dictionaryService.getAllByType(dictionaryType.getId())
            );
        }

        model.addAttribute("dictionaries", dictionariesByTypes);
        model.addAttribute("parameters", parameterService.getAll());

        model.addAttribute("types", getParameterTypes());

        model.addAttribute("queries", queryService.getAll());
        model.addAttribute("queryStates", QueryEntity.QUERY_STATES);

        return "main";
    }

    @RequestMapping(path = "/create_dictionary", method = RequestMethod.GET)
    public String createDictionary(Model model) {
        DictionaryEntity dictionary = new DictionaryEntity();
        sessionStorage.setEntityCreating(DictionaryEntity.class, true);

        return editDictionary(dictionary, model);
    }

    @RequestMapping(path = "/edit_dictionary/{id}", method = RequestMethod.GET)
    public String editDictionary(
            @PathVariable("id") Integer id,
            Model model
    ) {
        DictionaryEntity dictionary = dictionaryService.getById(id);
        sessionStorage.setEntityCreating(DictionaryEntity.class, false);

        return editDictionary(dictionary, model);
    }

    private String editDictionary(
            DictionaryEntity dictionary, Model model
    ) {
        sessionStorage.setEditingEntity(DictionaryEntity.class, dictionary);

        model.addAttribute("types", sessionStorage.getDictionaryTypes());
        model.addAttribute("dictionary",
                new DictionaryModel(dictionary)
        );

        return "edit_dictionary";
    }

    @RequestMapping(path = "/delete_dictionary/{id}", method = RequestMethod.GET)
    public String deleteDictionary(
            @PathVariable("id") Integer id
    ) {
        dictionaryService.remove(id);
        return "redirect:/#dictionaries";
    }

    @RequestMapping(path = "/save_dictionary", method = RequestMethod.POST)
    public String saveDictionary(@ModelAttribute("dictionary") DictionaryModel dictionaryModel) {
        DictionaryEntity savedDictionary = (DictionaryEntity) sessionStorage.getEditingEntity(DictionaryEntity.class);

        savedDictionary.setName(dictionaryModel.getName());
        savedDictionary.setDescription(dictionaryModel.getDescription());
        savedDictionary.setType(
                findById(
                        sessionStorage.getDictionaryTypes(),
                        dictionaryModel.getTypeId()
                )
        );

        if (sessionStorage.isEntityCreating(DictionaryEntity.class)) {
            dictionaryService.create(savedDictionary);
        } else {
            dictionaryService.update(savedDictionary);
        }

        sessionStorage.setEntityCreating(DictionaryEntity.class, false);

        return "redirect:/#dictionaries";
    }

    @RequestMapping(path = "/create_parameter", method = RequestMethod.GET)
    public String createParameter(Model model) {
        ParameterEntity parameter = new ParameterEntity();
        sessionStorage.setEntityCreating(ParameterEntity.class, true);

        return editParameter(parameter, model);
    }

    @RequestMapping(path = "/edit_parameter/{id}", method = RequestMethod.GET)
    public String editParameter(
            @PathVariable("id") Integer id,
            Model model
    ) {
        ParameterEntity parameter = parameterService.getById(id);
        sessionStorage.setEntityCreating(ParameterEntity.class, false);

        return editParameter(parameter, model);
    }

    private List<DomainNamedEntity> getParameterTypes() {
        List<DomainNamedEntity> parameterTypes = new ArrayList<>();
        parameterTypes.addAll(sessionStorage.getPrimitiveTypes());
        parameterTypes.addAll(sessionStorage.getDictionaryTypes());

        return parameterTypes;
    }

    private String editParameter(
            ParameterEntity parameter, Model model
    ) {
        sessionStorage.setEditingEntity(ParameterEntity.class, parameter);

        model.addAttribute("types", getParameterTypes());
        model.addAttribute("parameter",
                new ParameterModel(parameter)
        );

        return "edit_parameter";
    }

    @RequestMapping(path = "/delete_parameter/{id}", method = RequestMethod.GET)
    public String deleteParameter(
            @PathVariable("id") Integer id
    ) {
        parameterService.remove(id);
        return "redirect:/#parameters";
    }

    @RequestMapping(path = "/save_parameter", method = RequestMethod.POST)
    public String saveParameter(@ModelAttribute("parameter") ParameterModel parameterModel) {
        ParameterEntity savedParameter = (ParameterEntity) sessionStorage.getEditingEntity(ParameterEntity.class);

        savedParameter.setName(parameterModel.getName());
        savedParameter.setDescription(parameterModel.getDescription());
        savedParameter.setTypeId(parameterModel.getTypeId());

        if (sessionStorage.isEntityCreating(ParameterEntity.class)) {
            parameterService.create(savedParameter);
        } else {
            parameterService.update(savedParameter);
        }

        sessionStorage.setEntityCreating(ParameterEntity.class, false);

        return "redirect:/#parameters";
    }

    @RequestMapping(path = "/create_query", method = RequestMethod.GET)
    public String createQuery(Model model) {
        QueryEntity query = new QueryEntity();

        query.setTimeAdded(getCurrentDateTime());
        queryService.create(query);

        return "redirect:/#queries";
    }

    @RequestMapping(path = "/edit_query/{id}", method = RequestMethod.GET)
    public String editQuery(
            @PathVariable("id") Integer id,
            Model model
    ) {
        QueryEntity query = queryService.getById(id);
        return editQuery(query, model);
    }

    private Map<String, String> getValueNames() {
        Map<String, String> valueNames = new HashMap<>();

        for (DictionaryEntity dictionary : dictionaryService.getAll()) {
            valueNames.put(
                    Integer.toString(
                            dictionary.getId()
                    ),
                    dictionary.getName()
            );
        }

        return valueNames;
    }

    private String editQuery(
            QueryEntity query, Model model
    ) {
        sessionStorage.setEditingEntity(QueryEntity.class, query);

        model.addAttribute("query",
                new QueryModel(query)
        );

        model.addAttribute("queryParameter",
                new QueryParameterModel()
        );

        model.addAttribute("queryParameters",
                queryParameterService.getAllByQuery(query)
        );

        model.addAttribute("parameters",
                parameterService.getAll()
        );

        model.addAttribute("valueNames", getValueNames());

        return "edit_query";
    }

    @RequestMapping(path = "/delete_query/{id}", method = RequestMethod.GET)
    public String deleteQuery(
            @PathVariable("id") Integer id
    ) {
        queryService.remove(id);
        return "redirect:/#queries";
    }

    @RequestMapping(path = "/change_query_state/{id}", method = RequestMethod.GET)
    public String changeQueryState(
            @PathVariable("id") Integer id
    ) {
        QueryEntity query = queryService.getById(id);
        switch (query.getStateType()) {
            case QueryEntity.ADDED:
                query.setStateType(QueryEntity.STARTED);
                query.setTimeStarted(getCurrentDateTime());
                break;
            case QueryEntity.STARTED:
                query.setStateType(QueryEntity.FINISHED);
                query.setTimeFinished(getCurrentDateTime());
                query.setResultString(
                        "resultString#" + Math.random()
                );
                break;
            case QueryEntity.FINISHED:
            default:
                break;
        }

        return "redirect:/#queries";
    }

    @RequestMapping(path = "/save_query", method = RequestMethod.POST)
    public String saveQuery(@ModelAttribute("query") QueryModel queryModel) {
        QueryEntity savedQuery = (QueryEntity)sessionStorage.getEditingEntity(QueryEntity.class);

        queryService.update(savedQuery);
        sessionStorage.setEntityCreating(QueryEntity.class, false);

        return "redirect:/#queries";
    }

    private List<ParameterEntity> getParameters() {
        return parameterService.getAll();
    }

    @RequestMapping(path = "/create_query_parameter", method = RequestMethod.POST)
    public String createQueryParameter(
            @ModelAttribute("queryParameter") QueryParameterModel queryParameterModel,
            Model model) {
        QueryParameterEntity queryParameter = new QueryParameterEntity();

        QueryEntity editingQuery = (QueryEntity)sessionStorage.getEditingEntity(QueryEntity.class);
        queryParameter.setQueryId(editingQuery.id);

        ParameterEntity parameter = parameterService.getById(queryParameterModel.getParameterId());
        queryParameter.setParameter(parameter);

        sessionStorage.setEntityCreating(QueryParameterEntity.class, true);

        return editQueryParameter(
                queryParameter,
                model
        );
    }

    private List<DictionaryEntity> getValues(QueryParameterEntity queryParameter) {
        return dictionaryService.getAllByType(
                queryParameter.getParameter().getTypeId()
        );
    }

    @RequestMapping(path = "/edit_query_parameter/{id}", method = RequestMethod.GET)
    public String editQueryParameter(
            @PathVariable("id") Integer id,
            Model model
    ) {
        QueryParameterEntity queryParameter = queryParameterService.getById(id);
        sessionStorage.setEntityCreating(QueryParameterEntity.class, false);

        return editQueryParameter(queryParameter, model);
    }

    private String editQueryParameter(
            QueryParameterEntity queryParameter,
            Model model
    ) {
        sessionStorage.setEditingEntity(QueryParameterEntity.class, queryParameter);

        model.addAttribute("queryParameter",
                new QueryParameterModel(queryParameter)
        );

        model.addAttribute("parameter",
                new ParameterModel(queryParameter.getParameter())
        );

        model.addAttribute("dictionaryValues", getValues(queryParameter));

        return "edit_query_parameter";
    }

    @RequestMapping(path = "/delete_query_parameter/{id}", method = RequestMethod.GET)
    public String deleteQueryParameter(
            @PathVariable("id") Integer id
    ) {
        queryParameterService.remove(id);

        QueryEntity editingQuery = (QueryEntity)sessionStorage.getEditingEntity(QueryEntity.class);

        return "redirect:/edit_query/" + editingQuery.getId();
    }

    @RequestMapping(path = "/save_query_parameter", method = RequestMethod.POST)
    public String saveQueryParameter(
            @ModelAttribute("queryParameter") QueryParameterModel queryParameterModel
    ) {
        QueryParameterEntity savedQueryParameter = (QueryParameterEntity) sessionStorage.getEditingEntity(QueryParameterEntity.class);

        savedQueryParameter.setValue(queryParameterModel.getStringValue());

        if (sessionStorage.isEntityCreating(QueryParameterEntity.class)) {
            queryParameterService.create(savedQueryParameter);
        } else {
            queryParameterService.update(savedQueryParameter);
        }

        sessionStorage.setEntityCreating(QueryParameterEntity.class, false);

        QueryEntity editingQuery = (QueryEntity)sessionStorage.getEditingEntity(QueryEntity.class);

        return "redirect:/edit_query/" + editingQuery.getId();
    }

    private Timestamp getCurrentDateTime() {
        return Timestamp.valueOf(
                LocalDateTime.now()
        );
    }

    private <DomainType extends DomainEntity> DomainType findById(
            List<DomainType> domains, Integer id
    ) {
        for (DomainType domain : domains) {
            if (id.equals(domain.getId())) {
                return domain;
            }
        }

        return null;
    }
}
