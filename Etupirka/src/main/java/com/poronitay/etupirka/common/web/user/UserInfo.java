package com.poronitay.etupirka.common.web.user;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfo implements Serializable {

    @Getter
    @Setter
    private UserData userData;

    public boolean isLogin() {
        return userData != null;
    }


}
