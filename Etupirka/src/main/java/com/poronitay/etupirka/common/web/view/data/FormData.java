package com.poronitay.etupirka.common.web.view.data;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FormData<T> {

    private final Map<String, Object> formDataMap = new HashMap<>();

    private final String CONTENTS_FORM_DATA_KEY = "CONTENTS_FORM_DATA";

    @Getter
    @Setter
    private T contentsData;

    public void useContentsFormData(Object contentsFormData) {
        formDataMap.put(CONTENTS_FORM_DATA_KEY, contentsFormData);
    }

    @SuppressWarnings("unchecked")
    public <T> T getContentsData() {
        return (T) formDataMap.get(CONTENTS_FORM_DATA_KEY);
    }

}
