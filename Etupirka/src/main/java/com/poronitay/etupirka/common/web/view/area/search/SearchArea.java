package com.poronitay.etupirka.common.web.view.area.search;

import lombok.Getter;

public class SearchArea {

    @Getter
    private boolean showFlag = true;


    public void disable() {
        showFlag = false;
    }

}
