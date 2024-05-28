package com.admin.entity;

import com.admin.model.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "productOrder")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderEntity {

    @Id
    private int orderNo;
    private String orderState;

    @ManyToOne
    @JoinColumn(name="memNo", unique = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name="productNo", unique = false)
    private ProductEntity product;
}
