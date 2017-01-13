package com.slamur.app.neuro.controller;

import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.app.neuro.domain.dictionary.DictionaryModel;
import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.app.neuro.service.DictionaryService;
import com.slamur.app.neuro.service.DictionaryTypeService;
import com.slamur.app.neuro.service.ParameterTypeService;
import com.slamur.app.neuro.service.QueryService;
import com.slamur.app.neuro.session.SessionStorage;
import com.slamur.lib.domain.DomainEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Transactional
public class MainController {

    private final DictionaryService dictionaryService;

    private final DictionaryTypeService dictionaryTypeService;

    private final ParameterTypeService parameterTypeService;

    private final QueryService queryService;

    private final SessionStorage sessionStorage;

    @Autowired
    public MainController(
            DictionaryService dictionaryService,
            DictionaryTypeService dictionaryTypeService,
            ParameterTypeService parameterTypeService,
            QueryService queryService,
            SessionStorage sessionStorage
    ) {
        this.dictionaryService = dictionaryService;
        this.dictionaryTypeService = dictionaryTypeService;
        this.parameterTypeService = parameterTypeService;
        this.queryService = queryService;
        this.sessionStorage = sessionStorage;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        if (sessionStorage.getDictionaryTypes() == null) {
            sessionStorage.setDictionaryTypes(
                    dictionaryTypeService.getAll()
            );
        }

        Map<DictionaryTypeEntity, List<DictionaryEntity>> dictionariesByTypes = new HashMap<>();
        for (DictionaryTypeEntity dictionaryType : sessionStorage.getDictionaryTypes()) {
            dictionariesByTypes.put(
                    dictionaryType,
                    dictionaryService.getAllByType(dictionaryType.getId())
            );
        }

        model.addAttribute("dictionaries", dictionariesByTypes);
        model.addAttribute("parameterTypes", parameterTypeService.getAll());

        model.addAttribute("queries", queryService.getAll());


        return "main";
    }

    @RequestMapping(path = "/create_dictionary", method = RequestMethod.GET)
    public String createAlgorithm(Model model) {
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
    public String saveAlgorithm(@ModelAttribute("dictionary") DictionaryModel dictionaryModel) {
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

        return "redirect:/";
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
