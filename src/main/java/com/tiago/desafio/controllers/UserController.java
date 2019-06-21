package com.tiago.desafio.controllers;

import com.tiago.desafio.bo.UserBO;
import com.tiago.desafio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserBO userBO;

    @GetMapping
    public ModelAndView findAll(@RequestParam("page") int page) {
        this.userBO.registerDatasDatabase(page);
        List<User> users = this.userBO.findAll();
        ModelAndView view = new ModelAndView("user/index");
        view.addObject("users", users);
        return view;
    }
}
