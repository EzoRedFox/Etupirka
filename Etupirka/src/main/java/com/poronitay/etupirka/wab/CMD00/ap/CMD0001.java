package com.poronitay.etupirka.wab.CMD00.ap;

import org.springframework.stereotype.Service;

import com.poronitay.etupirka.common.web.user.UserData;

@Service
public class CMD0001 {

    public UserData getUserData(String userID) {

        UserData user = new UserData();
        user.setUserName(userID + "太郎");
        user.setAffiliation(userID + "第１課テスト係：主任");
        return user;
    }
}
