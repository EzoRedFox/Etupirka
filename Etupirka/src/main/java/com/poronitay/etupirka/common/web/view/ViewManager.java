package com.poronitay.etupirka.common.web.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.poronitay.etupirka.common.web.view.area.ViewArea;
import com.poronitay.etupirka.common.web.view.area.button.ButtonArea;
import com.poronitay.etupirka.common.web.view.area.message.MessageArea;
import com.poronitay.etupirka.common.web.view.area.search.SearchArea;
import com.poronitay.etupirka.common.web.view.data.ViewCommonData;
import com.poronitay.etupirka.common.web.view.data.ViewData;
import com.poronitay.etupirka.common.web.view.user.UserInfo;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ViewManager implements Serializable {

    @Autowired
    private UserInfo user;

    private List<ViewCommonData> historyList = new ArrayList<>();


    public String getViewId () {
        return getCurrentViewData().getViewId();
    }

    public String getViewTitle () {
        return getCurrentViewData().getViewTitle();
    }

    public MessageArea getMessageArea () {
        return getCurrentViewArea().getMessageArea();
    }

    public ButtonArea getButtonArea() {
        return getCurrentViewArea().getButtonArea();
    }

    public SearchArea getSearchArea() {
        return getCurrentViewArea().getSearchArea();
    }



    public String redirectTo(String viewId) {
        // 指定したViewIDが閲覧可能かをチェックする
        Optional<ViewData> viewDataOpt = user.getViewData(viewId);
        if (viewDataOpt.isEmpty()) {
            // 閲覧不可として何もしない
            getMessageArea().clear();
            getMessageArea().addErrorMessage("不正な画面遷移のリクエストが呼び出されました。");
            return selfRepaint();
        }

        // CMM00かCMM01へのマッピングの場合は履歴をクリアする
        if (viewId.contentEquals("CMD00") || viewId.contentEquals("CMD01")) {
            historyList.clear();
        }

        // 指定したURLのマッピングをカレントとして履歴に追加する
        historyList.add(new ViewCommonData(viewDataOpt.get()));

        // マッピングURLを返す
        return redirectCurrentView();
    }

    public String back() {
        // 現在のViewDataを履歴から削除
        historyList.remove(historyList.size() - 1 );
        // 削除後にカレントとなるURLを返す
        return redirectCurrentView();
    }


    public String back(int historyIndex) {

        // 配列外であれば最後の画面とする
        if (historyIndex < 0 || historyIndex >= historyList.size()) {
            return redirectCurrentView();
        }
        // 履歴番号まで配列を削除する(配列外であれば何もしない)
        while (historyList.size() -1 > historyIndex) {
            historyList.remove(historyList.size() -1);
        }
        return redirectCurrentView();

    }

    private String redirectCurrentView() {
        return "redirect:/" + getCurrentViewData().getViewId();
    }

    public String selfRepaint() {
        return getCurrentViewData().getViewId();
    }

    public String selfRepaint(Model model, Object value) {
        model.addAttribute("contentsData", value);
        return getCurrentViewData().getViewId();
    }


    public List<String> getHistoryViewNameList() {
        return historyList.stream()
                .map(h -> h.getViewData())
                .map(v -> v.getViewTitle())
                .collect(Collectors.toList());
    }

    private ViewData getCurrentViewData() {
        return historyList.get(historyList.size() - 1).getViewData();
    }

    private ViewArea getCurrentViewArea() {
        return historyList.get(historyList.size() - 1).getViewArea();
    }

}
