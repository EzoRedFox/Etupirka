package com.poronitay.etupirka.common.web.view.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class ViewCategory {

    private final String categoryId;

    private final String categoryName;

    private final List<ViewData> viewList = new ArrayList<>();

    public ViewCategory(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public void addViewData(ViewData viewData) {
        viewList.add(viewData);
    }

    public boolean containsViewId(String viewId) {
        return viewList.stream().anyMatch(v -> v.getViewId().equals(viewId));
    }

    public Optional<ViewData> getViewData(String viewId) {
        return viewList.stream().filter(v -> v.getViewId().equals(viewId)).findFirst();
    }

}
