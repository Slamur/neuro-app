package com.slamur.app.neuro.controller;

import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.app.neuro.domain.dictionary.DictionaryModel;
import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.app.neuro.domain.parameter.ParameterEntity;
import com.slamur.app.neuro.domain.parameter.ParameterModel;
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

import java.util.*;

@Controller
@Transactional
public class MainController {

    private final DictionaryService dictionaryService;

    private final DictionaryTypeService dictionaryTypeService;

    private final ParameterService parameterService;

    private final PrimitiveTypeService primitiveTypeService;

    private final QueryService queryService;

    private final SessionStorage sessionStorage;

    @Autowired
    public MainController(
            DictionaryService dictionaryService,
            DictionaryTypeService dictionaryTypeService,
            ParameterService parameterService,
            PrimitiveTypeService primitiveTypeService,
            QueryService queryService,
            SessionStorage sessionStorage
    ) {
        this.dictionaryService = dictionaryService;
        this.dictionaryTypeService = dictionaryTypeService;
        this.parameterService = parameterService;
        this.primitiveTypeService = primitiveTypeService;
        this.queryService = queryService;
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


        return "main";
    }

    @RequestMapping(path = "/create_dictionary", method = RequestMethod.GET)
    public String createDictionary(Model model) {
        DictionaryEntity dictionary = new DictionaryEntity();
        sessionStorage.setEntityCreating(true);

        return editDictionary(dictionary, model);
    }

    @RequestMapping(path = "/edit_dictionary/{id}", method = RequestMethod.GET)
    public String editDictionary(
            @PathVariable("id") Integer id,
            Model model
    ) {
        DictionaryEntity dictionary = dictionaryService.getById(id);
        sessionStorage.setEntityCreating(false);

        return editDictionary(dictionary, model);
    }

    private String editDictionary(
            DictionaryEntity dictionary, Model model
    ) {
        sessionStorage.setEditingEntity(dictionary);

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
        return "redirect:/";
    }

    @RequestMapping(path = "/save_dictionary", method = RequestMethod.POST)
    public String saveDictionary(@ModelAttribute("dictionary") DictionaryModel dictionaryModel) {
        DictionaryEntity savedDictionary = (DictionaryEntity) sessionStorage.getEditingEntity();

        savedDictionary.setName(dictionaryModel.getName());
        savedDictionary.setDescription(dictionaryModel.getDescription());
        savedDictionary.setType(
                findById(
                        sessionStorage.getDictionaryTypes(),
                        dictionaryModel.getTypeId()
                )
        );

        if (sessionStorage.isEntityCreating()) {
            dictionaryService.create(savedDictionary);
        } else {
            dictionaryService.update(savedDictionary);
        }

        sessionStorage.setEntityCreating(false);

        return "redirect:/#dictionaries";
    }

    @RequestMapping(path = "/create_parameter", method = RequestMethod.GET)
    public String createParameter(Model model) {
        ParameterEntity parameter = new ParameterEntity();
        sessionStorage.setEntityCreating(true);

        return editParameter(parameter, model);
    }

    @RequestMapping(path = "/edit_parameter/{id}", method = RequestMethod.GET)
    public String editParameter(
            @PathVariable("id") Integer id,
            Model model
    ) {
        ParameterEntity parameter = parameterService.getById(id);
        sessionStorage.setEntityCreating(false);

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
        sessionStorage.setEditingEntity(parameter);

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
        return "redirect:/";
    }

    @RequestMapping(path = "/save_parameter", method = RequestMethod.POST)
    public String saveParameter(@ModelAttribute("parameter") ParameterModel parameterModel) {
        ParameterEntity savedParameter = (ParameterEntity) sessionStorage.getEditingEntity();

        savedParameter.setName(parameterModel.getName());
        savedParameter.setDescription(parameterModel.getDescription());
        savedParameter.setTypeId(parameterModel.getTypeId());

        if (sessionStorage.isEntityCreating()) {
            parameterService.create(savedParameter);
        } else {
            parameterService.update(savedParameter);
        }

        sessionStorage.setEntityCreating(false);

        return "redirect:/#parameters";
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
