package com.slamur.app.neuro.controller;

import com.slamur.app.neuro.model.AlgorithmEntity;
import com.slamur.app.neuro.service.AlgorithmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

    private AlgorithmService algorithmService;

    public void setAlgorithmService(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<AlgorithmEntity> algorithms = algorithmService.getAll();
        model.addAttribute("algorithms", algorithms);

        return "index";
    }
}
