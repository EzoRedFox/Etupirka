package com.poronitay.etupirka.common.web.view.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserData  implements Serializable {

    private String userId;

    private String userName;

    private String affiliation;



}
