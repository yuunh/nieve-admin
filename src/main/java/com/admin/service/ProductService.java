package com.admin.service;

import com.admin.entity.ProductEntity;
import com.admin.model.Product;
import com.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;

    public List<Product> getProductList() {
        List<ProductEntity> productList = productRepository.findAll();

        List<Product> products = new ArrayList<>();
        for (ProductEntity pe : productList) {
            Product p = Product.builder()
                    .productNo(pe.getProductNo())
                    .productName(pe.getProductName())
                    .productPrice(pe.getProductPrice())
                    .build();
            products.add(p);
        }

        return products;
    }

    public int addProduct(Product product){
        ProductEntity entity = ProductEntity.builder()
                        .productName(product.getProductName())
                        .productPrice(product.getProductPrice())
//                        .categoryNo(product.getCategoryNo())
                        .build();
        productRepository.save(entity);
        return 0;
    }
}
