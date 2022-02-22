package com.bobocode.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Welcome controller that consists of one method that handles get request to "/" and "/welcome" and respond with a message.
 */

@Controller
public class WelcomeController {

    @GetMapping({"/", "/welcome"})
    public String welcome(){
        return "welcome";
    }
}
