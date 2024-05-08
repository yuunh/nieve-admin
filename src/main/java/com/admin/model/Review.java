package com.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Review {

    private String reviewTitle;
    private String reviewContent;
    private Date reviewDate;
    private String fileName;
    private String memEmail;
    private String productName;
}