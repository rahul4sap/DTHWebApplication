package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springboot.service.DTHService;

@Controller
public class LoginController {

	@Autowired
	private DTHService dthService;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
    	model.put("users", dthService.retrieveAllUsers());
        return "welcome";
    }

}