package com.poronitay.etupirka.common.web.view.data;

import com.poronitay.etupirka.common.web.view.ViewArea;

import lombok.Getter;

public class ViewData {

    @Getter
    private final String viewId;

    @Getter
    private final String viewName;

    @Getter
    private final ViewArea viewArea;

    public ViewData(String viewId, String viewName) {
        this.viewId = viewId;
        this.viewName = viewName;
        viewArea = new ViewArea(viewId);
    }


}
