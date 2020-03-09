package com.poronitay.etupirka.common.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poronitay.etupirka.common.web.view.ViewManager;

@Controller
@RequestMapping("/")
public class InitController {

    @Autowired
    private ViewManager viewManager;

    @RequestMapping
    public String init() {
        return viewManager.redirectTo("CMD00");
    }

}
