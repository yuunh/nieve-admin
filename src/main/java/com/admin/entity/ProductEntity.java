package com.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Entity(name = "product")
@Data
@Getter
public class ProductEntity {

    @Id
    private int productNo;
    private String productName;
    private double productPrice;
}