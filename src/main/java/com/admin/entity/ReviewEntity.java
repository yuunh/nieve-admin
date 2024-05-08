package com.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Entity(name = "review")
@Data
@Getter
public class ReviewEntity {

    @Id
    private int reviewNo;
    private String reviewTitle;
    private String reviewContent;
    private Date reviewDate;

    @ManyToOne
    @JoinColumn(name="fileNo", unique = false)
    private FileEntity file;

    @ManyToOne
    @JoinColumn(name="memNo", unique = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name="productNo", unique = false)
    private ProductEntity product;
}
