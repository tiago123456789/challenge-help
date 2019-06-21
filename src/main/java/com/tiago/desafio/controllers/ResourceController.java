package com.tiago.desafio.controllers;

import com.tiago.desafio.bo.ResourceBO;
import com.tiago.desafio.bo.UserBO;
import com.tiago.desafio.model.Resource;
import com.tiago.desafio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceBO resourceBO;

    @GetMapping
    public ModelAndView findAll(@RequestParam("page") int page) {
        this.resourceBO.registerDatasDatabase(page);
        List<Resource> resources = this.resourceBO.findAll();
        ModelAndView view = new ModelAndView("resource/index");
        view.addObject("resources", resources);
        return view;
    }
}
