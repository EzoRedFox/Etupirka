package com.poronitay.etupirka.common.web.view.data;

import lombok.Data;

@Data
public class ViewData {

    private final String viewId;

    private final String viewTitle;

    private final boolean onMenuLink;

    public ViewData(String viewId, String viewTitle, boolean onMenuLink) {
        this.viewId = viewId;
        this.viewTitle = viewTitle;
        this.onMenuLink = onMenuLink;
    }
}
