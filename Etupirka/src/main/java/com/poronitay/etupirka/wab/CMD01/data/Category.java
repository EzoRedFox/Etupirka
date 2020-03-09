package com.poronitay.etupirka.wab.CMD01.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Category {

    private final String categoryName;

    private final List<MenuLink> menuList = new ArrayList<>();


    public void addMenuLink(MenuLink menuLink) {
        menuList.add(menuLink);
    }


}
