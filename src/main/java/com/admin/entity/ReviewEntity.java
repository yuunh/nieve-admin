package com.admin.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Entity(name = "review")
@Data
@Getter
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNo;
    private String reviewTitle;
    private String reviewContent;
    private Date reviewDate;
    private int reviewStar;
    private String reviewState;

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
