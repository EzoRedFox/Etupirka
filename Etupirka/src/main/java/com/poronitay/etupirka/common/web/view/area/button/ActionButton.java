package com.poronitay.etupirka.common.web.view.area.button;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ActionButton implements Serializable {

    @Getter
    private final String buttonName;

    @Getter
    private final String actionName;

    @Getter
    @Setter
    private boolean activeFlg = true;

    public ActionButton(String buttonName, String actionName) {
        this.buttonName = buttonName;
        this.actionName = actionName;
    }

}
