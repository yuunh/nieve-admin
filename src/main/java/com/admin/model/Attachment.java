package com.admin.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attachment {

    private int fileNo;
    private String originName;
    private String changeName;
    private String filePath;
    private Date uploadDate;
    private int fileLevel;
    private String status;
}
