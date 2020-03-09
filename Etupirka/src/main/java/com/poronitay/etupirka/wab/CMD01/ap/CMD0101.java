package com.poronitay.etupirka.wab.CMD01.ap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poronitay.etupirka.wab.CMD01.data.Category;
import com.poronitay.etupirka.wab.CMD01.data.MenuLink;

@Service
public class CMD0101 {



    public List<Category> getMenuList() {
        List<Category> list = new ArrayList<>();

        Category category = new Category("事務業務");
        category.addMenuLink(new MenuLink("勤怠表","ORD01"));
        category.addMenuLink(new MenuLink("TEST1","ORD02"));
        category.addMenuLink(new MenuLink("TEST2","ORD03"));
        list.add(category);

        category = new Category("営業管理");
        category.addMenuLink(new MenuLink("受注処理","ORD01"));
        category.addMenuLink(new MenuLink("TEST1","ORD02"));
        category.addMenuLink(new MenuLink("TEST2","ORD03"));
        list.add(category);

        category = new Category("発注管理");
        category.addMenuLink(new MenuLink("発注処理","ORD01"));
        category.addMenuLink(new MenuLink("TEST1","ORD02"));
        category.addMenuLink(new MenuLink("TEST2","ORD03"));
        list.add(category);


        return list;
    }


}
