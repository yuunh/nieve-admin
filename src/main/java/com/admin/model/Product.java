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
    private int categoryNo;
    private String categoryName;
}
