package com.poronitay.etupirka.wab.CMD00;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poronitay.etupirka.common.web.user.UserData;
import com.poronitay.etupirka.common.web.user.UserInfo;
import com.poronitay.etupirka.common.web.view.ViewManager;
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

    private final CMD0001 cmd0001;

    private final UserInfo userInfo;

    @RequestMapping
    public String init(Model model) {

        viewManager.getButtonArea().disable();
        viewManager.getSearchArea().disable();

        CMD00Data data = new CMD00Data();
        data.setUserId("TEST_ID");

        return viewManager.selfRepaint(model, data);
    }

    @RequestMapping(params = "login")
    public String login(@ModelAttribute(name = "contentsData") CMD00Data data, Model model) {

        UserData user = cmd0001.getUserData(data.getUserId());
        userInfo.setUserData(user);

        return viewManager.redirectTo("CMD01");
    }


}
