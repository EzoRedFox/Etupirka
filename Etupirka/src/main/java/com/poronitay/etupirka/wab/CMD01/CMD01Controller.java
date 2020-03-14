package com.poronitay.etupirka.wab.CMD01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poronitay.etupirka.common.web.view.ViewManager;
import com.poronitay.etupirka.common.web.view.user.UserInfo;
import com.poronitay.etupirka.wab.CMD01.ap.CMD0101;
import com.poronitay.etupirka.wab.CMD01.data.CMD01Data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("CMD01")
public class CMD01Controller {

    private final ViewManager viewManager;

    private final UserInfo userInfo;

    private final CMD0101 cmd0101;

    @RequestMapping
    public String init(Model model) {

        viewManager.getButtonArea().disable();
        viewManager.getSearchArea().disable();

        var list = userInfo.getViewableCategoryList();
        if(list.isEmpty()) {
            viewManager.getMessageArea().addErrorMessage("閲覧できるコンテンツはありません。");
        }
        CMD01Data data = new CMD01Data();
        data.setMenuList(list);
        return viewManager.selfRepaint(model, data);
    }

}
