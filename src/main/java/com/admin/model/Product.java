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
    private double productPrice;
}
