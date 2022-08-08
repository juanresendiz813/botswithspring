package com.bots.botswithspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import twitter4j.TwitterException;

import java.util.List;

@Controller
public class RootController {

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String index(Model model) throws TwitterException {
        model.addAttribute("obj", "Welcome. To get started go to /twitter.");
        return "index";
    }
}
