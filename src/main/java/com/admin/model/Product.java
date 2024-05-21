package com.admin.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private int productNo;
    private String productName;
    private int productPrice;
    private int productStock;
    private String productState;
    private int categoryNo;
    private String categoryName;
    private Integer fileNo1;
    private String fileName1;
    private Integer fileNo2;
    private String fileName2;
    private Integer fileNo3;
    private String fileName3;
}
