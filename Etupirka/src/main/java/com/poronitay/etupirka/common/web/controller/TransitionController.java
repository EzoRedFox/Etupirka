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

    /**
     * 履歴情報から一つ前の画面に遷移する。
     * @return
     */
    @RequestMapping("back")
    public String backAction () {
        return viewManager.back();
    }

    /**
     * 履歴情報から、指定した番号の画面へ遷移する。
     * @param historyIndex
     * @return
     */
    @RequestMapping("historyBack")
    public String historyBackAction(@RequestParam Optional<Integer> historyIndex) {
        if (!historyIndex.isPresent()) {
            return viewManager.selfRepaint();
        }
        return viewManager.back(historyIndex.get());
    }

    /**
     * 指定したViewIDに紐づく画面へ遷移する。
     * @param viewId
     * @return
     */
    @RequestMapping("nextView")
    public String toNextViewAction(@RequestParam Optional<String> viewId) {
        if (!viewId.isPresent()) {
            return viewManager.selfRepaint();
        }
        return viewManager.redirectTo(viewId.get());
    }

}
