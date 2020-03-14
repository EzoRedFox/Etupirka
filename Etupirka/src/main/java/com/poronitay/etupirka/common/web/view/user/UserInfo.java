package com.poronitay.etupirka.common.web.view.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.poronitay.etupirka.common.web.view.data.ViewCategory;
import com.poronitay.etupirka.common.web.view.data.ViewData;

import lombok.Getter;


@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfo implements Serializable {

    @Getter
    private final UserData userData = new UserData();

    @Getter
    private final List<ViewCategory> viewableCategoryList = new ArrayList<>();

    /**
     * コンストラクタ
     * 初期値としてログイン、メニュー画面は閲覧可能とする
     */
    public UserInfo() {
        ViewCategory category = new ViewCategory("CMD","共通");
        category.addViewData(new ViewData("CMD00","ログイン", false));
        category.addViewData(new ViewData("CMD01","メニュー", false));
        viewableCategoryList.add(category);
    }

    /**
     * <pre>
     * 現在ログイン中であるかを返す。
     * ここでは、ユーザIDがセットされている場合にtrueとする。
     * </pre>
     * @return
     */
    public boolean isLogin() {
        return userData.getUserId() != null;
    }

    /**
     * <pre>
     * 指定されたユーザIDを基に、権限の取得、閲覧可能な画面の作成などの
     * 初期設定を行う。
     * ユーザの基本情報が取得できない場合はユーザIDのセットは行わず、falseを返す。
     * 基本情報が取得できた段階でtrueとする。
     * </pre>
     * @param userId
     * @return
     */
    public boolean login(String userId) {

        // ユーザの基本情報作成
        userData.setUserId(userId);
        userData.setUserName(userId + "太郎");

        // ユーザの権限作成
        userData.setAffiliation(userId + "第１課テスト係：主任");

        // 閲覧可能な画面のリストを作成
        ViewCategory category = new ViewCategory("ZID","事務業務");
        category.addViewData(new ViewData("ZID01","勤怠表", true));
        category.addViewData(new ViewData("ZID02","勤怠表承認", true));
        category.addViewData(new ViewData("ZID03","テストリンク", true));
        viewableCategoryList.add(category);
        category = new ViewCategory("ORD","営業管理");
        category.addViewData(new ViewData("ORD01","受注一覧", true));
        category.addViewData(new ViewData("ORD02","見積書作成", true));
        category.addViewData(new ViewData("ORD03","テストリンク", true));
        viewableCategoryList.add(category);
        category = new ViewCategory("HAD0","発注管理");
        category.addViewData(new ViewData("HAD01","BP情報", true));
        category.addViewData(new ViewData("HAD02","発注表", true));
        category.addViewData(new ViewData("HAD03","清算表", true));
        viewableCategoryList.add(category);




        return true;
    }

    /**
     * 指定されたViewIDが閲覧可能なView一覧に存在すれば、そのIDに対応するViewData返す。
     * @param viewId
     * @return Optional:ViewData
     */
    public Optional<ViewData> getViewData(String viewId) {
        // 閲覧可能なView一覧から指定したViewIDが存在すればそれを返す
        Optional<ViewCategory> category = viewableCategoryList.stream()
                .filter(v -> v.containsViewId(viewId))
                .findFirst();
        if (category.isEmpty()) {
            return Optional.empty();
        }
        return category.get().getViewData(viewId);
    }


}
