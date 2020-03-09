package com.poronitay.etupirka.common.web.user;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserData  implements Serializable {

    private String affiliation;
    private String userName;


}
