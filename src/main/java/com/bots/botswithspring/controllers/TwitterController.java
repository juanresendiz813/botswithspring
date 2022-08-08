package com.bots.botswithspring.controllers;

import com.bots.botswithspring.bots.twitter.TwitterBotInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import twitter4j.TwitterException;
import java.util.List;



@Controller
public class TwitterController {
    private TwitterBotInter ti;
    @Autowired
    public void TwitterBot(TwitterBotInter twitterBotInter){
        this.ti = twitterBotInter;
    }

    @RequestMapping(value = "/twitter", method = {RequestMethod.GET})
    public String twitterIndex(Model model) throws TwitterException {
        List<String> l = ti.landingList();
        model.addAttribute("obj", l);
        return "index";
    }
}
