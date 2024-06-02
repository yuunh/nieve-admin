package com.admin.entity;

import com.admin.model.Product;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity(name = "productOrder")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderEntity {

    @Id
    private Integer orderNo;
    private String orderState;
    private String address;
    private Integer postNo;
    private Integer phone;
    private Integer totalPrice;
    private String message;


    @ManyToOne
    @JoinColumn(name="memNo", unique = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name="productNo", unique = false)
    private ProductEntity product;
}
