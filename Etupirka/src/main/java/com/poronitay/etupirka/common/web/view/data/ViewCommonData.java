package com.poronitay.etupirka.common.web.view.data;

import com.poronitay.etupirka.common.web.view.area.ViewArea;

import lombok.Getter;

public class ViewCommonData {

    @Getter
    private final ViewData viewData;

    @Getter
    private final ViewArea viewArea;

    public ViewCommonData(ViewData viewData) {
        this.viewData = viewData;
        viewArea = new ViewArea(viewData.getViewId());
    }


}
