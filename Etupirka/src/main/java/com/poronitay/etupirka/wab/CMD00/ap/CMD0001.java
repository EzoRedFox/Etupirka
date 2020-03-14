package com.poronitay.etupirka.wab.CMD00.ap;

import org.springframework.stereotype.Service;

@Service
public class CMD0001 {

    /**
     * 指定したユーザID、パスワードが正しいかをチェックする
     * @param userID
     * @param password
     * @return true:ユーザID、パスワードの検証OK
     */
    public boolean checkUserIdPassword(String userID, String password) {

        return true;
    }
}
