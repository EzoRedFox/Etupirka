package com.poronitay.etupirka.common.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poronitay.etupirka.common.web.view.ViewManager;
import com.poronitay.etupirka.common.web.view.user.UserInfo;

@Controller
@RequestMapping("/")
public class InitController {

    @Autowired
    private ViewManager viewManager;

    @Autowired
    private UserInfo userInfo;

    @RequestMapping
    public String init() {
        return viewManager.redirectTo("CMD00");
    }

}
