package com.poronitay.etupirka.common.web.view.area.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class MessageArea implements Serializable {

    @Getter
    private final List<String> messageList = new ArrayList<>();

    @Getter
    private final List<String> errorMessageList = new ArrayList<>();

    public MessageArea(String viewId) {

    }

    public boolean hasMessage() {
        return errorMessageList.isEmpty() && !messageList.isEmpty();
    }

    public boolean hasErrorMessage() {
        return !errorMessageList.isEmpty();
    }

    public void addMessage(String message) {
        messageList.add(message);
    }

    public void addErrorMessage(String message) {
        errorMessageList.add(message);
    }

    public void clear() {
        messageList.clear();
        errorMessageList.clear();
    }

}
