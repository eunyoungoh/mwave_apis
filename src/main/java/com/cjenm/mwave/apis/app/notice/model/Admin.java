package com.cjenm.mwave.apis.app.notice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Admin {
    private String userId;
    private String password;
    private String userName;
    private String company;
}
