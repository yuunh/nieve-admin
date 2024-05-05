package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity(name = "product")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productNo;
    private String productName;
    private int productPrice;
    private int productStock;

    @OneToOne
    @JoinColumn(name="categoryNo")
    private CategoryEntity category;

//    @Column(insertable = false, updatable = false)
//    @ColumnDefault("2")
//    private int categoryNo;
}
