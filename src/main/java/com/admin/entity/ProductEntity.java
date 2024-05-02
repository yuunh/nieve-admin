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

    @Column(insertable = false, updatable = false)
    @ColumnDefault("2")
    private int categoryNo;

    @OneToOne
    @JoinTable(name = "category", // 조인테이블명
            joinColumns = @JoinColumn(name = "categoryNo"), // 본인 테이블 외래키
            inverseJoinColumns = @JoinColumn(name = "categoryNo")) // 반대 엔티티(조인테이블)의 외래키
    private CategoryEntity category;
}
