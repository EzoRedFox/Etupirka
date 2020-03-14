package com.poronitay.etupirka.common.web.view.area;

import com.poronitay.etupirka.common.web.view.area.button.ButtonArea;
import com.poronitay.etupirka.common.web.view.area.message.MessageArea;
import com.poronitay.etupirka.common.web.view.area.search.SearchArea;

import lombok.Getter;

public class ViewArea {


    @Getter
    private final MessageArea messageArea;

    @Getter
    private final ButtonArea buttonArea;

    @Getter
    private final SearchArea searchArea;


    public ViewArea(String viewId) {
        messageArea = new MessageArea(viewId);
        buttonArea = new ButtonArea(viewId);
        searchArea = new SearchArea();
    }

}
