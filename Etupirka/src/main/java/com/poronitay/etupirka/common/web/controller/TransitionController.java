package com.poronitay.etupirka.common.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poronitay.etupirka.common.web.view.ViewManager;

@Controller
@RequestMapping("transition")
public class TransitionController {

    @Autowired
    private ViewManager viewManager;

    @RequestMapping("back")
    public String backAction () {
        return viewManager.back();
    }

    @RequestMapping("historyBack")
    public String historyBackAction(@RequestParam Optional<Integer> historyIndex) {
        if (!historyIndex.isPresent()) {
            return viewManager.selfRepaint();
        }
        return viewManager.back(historyIndex.get());
    }

}
