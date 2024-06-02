package com.admin.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductOrder {

    private int orderNo;
    private String productName;
    private int productPrice;
    private String memEmail;
    private String orderState;
    private String memName;
    private String address;
    private Integer postNo;
    private Integer phone;
    private Integer totalPrice;
    private String message;

}
