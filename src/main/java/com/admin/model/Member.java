package com.admin.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

    private int memNo;
    private String memEmail;
    private String memName;
    private String memPwd;
    private String phone;
    private String address1;
    private String address2;
    private String postNo;
    private String adCheck;
    private Date enrollDate;
}
