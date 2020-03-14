package com.poronitay.etupirka.wab.CMD00;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poronitay.etupirka.common.web.view.ViewManager;
import com.poronitay.etupirka.common.web.view.user.UserInfo;
import com.poronitay.etupirka.wab.CMD00.ap.CMD0001;
import com.poronitay.etupirka.wab.CMD00.data.CMD00Data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("CMD00")
public class CMD00Controller {

    private final ViewManager viewManager;

    private final UserInfo user;

    private final CMD0001 cmd0001;

    @RequestMapping
    public String init(Model model) {

        viewManager.getButtonArea().disable();
        viewManager.getSearchArea().disable();

        return viewManager.selfRepaint(model, new CMD00Data());
    }

    @RequestMapping(params = "login")
    public String login(@ModelAttribute(name = "contentsData") CMD00Data data, Model model) {
        // ユーザID、パスワードが正しいかを確認する
        if (cmd0001.checkUserIdPassword(data.getUserId(), data.getPassword())) {
            viewManager.getMessageArea().addErrorMessage("ユーザIDまたはパスワードが不正です。");
        }
        // ユーザIDに紐づきログインを行う
        if (!user.login(data.getUserId())) {
            viewManager.getMessageArea().addErrorMessage("ログインに失敗しました。");
        }
        return viewManager.redirectTo("CMD01");
    }


}
