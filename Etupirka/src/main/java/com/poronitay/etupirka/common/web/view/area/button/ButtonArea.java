package com.poronitay.etupirka.common.web.view.area.button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ButtonArea implements Serializable {

    private final String viewId;

    @Getter
    private boolean showFlag = true;

    @Getter
    private List<ActionButton> buttonList = new ArrayList<>();

    public ButtonArea(String viewId) {
        this.viewId = viewId;
        // 戻るボタンをデフォルトで実装
        addButton(new ActionButton("戻る", ""));
    }

    public void disable() {
        showFlag = false;
    }

    public void addButton(ActionButton actionButton) {
        buttonList.add(actionButton);
    }



}
