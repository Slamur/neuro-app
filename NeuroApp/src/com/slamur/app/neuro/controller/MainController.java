package com.slamur.app.neuro.controller;

import com.slamur.app.neuro.service.AlgorithmService;
import com.slamur.app.neuro.service.NetworkService;
import com.slamur.app.neuro.service.ParameterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private AlgorithmService algorithmService;

    @Autowired
    private NetworkService networkService;

    @Autowired
    private ParameterTypeService parameterTypeService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("algorithms", algorithmService.getAll());
        model.addAttribute("networks", networkService.getAll());
        model.addAttribute("parameterTypes", parameterTypeService.getAll());

        return "main";
    }
}
