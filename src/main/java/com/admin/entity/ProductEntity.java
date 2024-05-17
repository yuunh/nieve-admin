package com.admin.entity;

import com.admin.model.Product;
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
    private String productState;

    @ManyToOne
    @JoinColumn(name="fileNo1", unique = false)
    private FileEntity file1;
    @ManyToOne
    @JoinColumn(name="fileNo2", unique = false)
    private FileEntity file2;
    @ManyToOne
    @JoinColumn(name="fileNo3", unique = false)
    private FileEntity file3;

    @ManyToOne
    @JoinColumn(name="categoryNo", unique = false)
    private CategoryEntity category;

    public Product toModel() {
        CategoryEntity ce = this.getCategory();
        FileEntity fe1 = this.getFile1();
        FileEntity fe2 = this.getFile2();
        FileEntity fe3 = this.getFile3();
        Product p = Product.builder()
                .productNo(this.getProductNo())
                .productName(this.getProductName())
                .productPrice(this.getProductPrice())
                .productStock(this.getProductStock())
                .categoryNo(ce.getCategoryNo())
                .categoryName(ce.getCategoryName())
                .fileNo1(fe1.getFileNo())
                .fileNo2(fe2.getFileNo())
                .fileNo3(fe3.getFileNo())
                .build();

        if(fe1 != null){
            p.setFileNo1(fe1.getFileNo());
            p.setFileName1(fe1.getChangeName());
        }
        if(fe2 != null){
            p.setFileNo2(fe2.getFileNo());
            p.setFileName2(fe2.getChangeName());
        }
        if(fe3 != null){
            p.setFileNo3(fe3.getFileNo());
            p.setFileName3(fe3.getChangeName());
        }
        return p;
    }
}
