package com.admin.service;

import com.admin.entity.CategoryEntity;
import com.admin.entity.FileEntity;
import com.admin.entity.ProductEntity;
import com.admin.model.Category;
import com.admin.model.Product;
import com.admin.repository.CategoryRepository;
import com.admin.repository.FileRepository;
import com.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private FileRepository fileRepository;

    public List<Product> getProductList() {
        List<ProductEntity> productList = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity pe : productList) {
            CategoryEntity ce = pe.getCategory();
            Product p = Product.builder()
                    .productNo(pe.getProductNo())
                    .productName(pe.getProductName())
                    .productPrice(pe.getProductPrice())
                    .productStock(pe.getProductStock())
                    .categoryName(ce.getCategoryName())
                    .build();
            products.add(p);
        }

        return products;
    }

    public void addProduct(Product product){
        CategoryEntity category = categoryRepository.findById(product.getCategoryNo()).orElseThrow();
        FileEntity file = fileRepository.findById(product.getFileNo()).orElseThrow();
        ProductEntity entity = ProductEntity.builder()
                        .productName(product.getProductName())
                        .productPrice(product.getProductPrice())
                        .productStock(product.getProductStock())
                        .file(file)
                .category(category)
                        .build();
        productRepository.save(entity);
    }


    public Product getProduct(int productNo) {
        ProductEntity pe = productRepository.findById(productNo).orElseThrow();
        CategoryEntity ce = pe.getCategory();
        FileEntity fe = pe.getFile();
        Product p = Product.builder()
                .productName(pe.getProductName())
                .productPrice(pe.getProductPrice())
                .productStock(pe.getProductStock())
                .categoryNo(ce.getCategoryNo())
                .categoryName(ce.getCategoryName())
                .fileNo(fe.getFileNo())
                .build();

        if(fe != null){
            p.setFileNo(fe.getFileNo());
            p.setFileName(fe.getChangeName());
        }
        return p;
    }
}
