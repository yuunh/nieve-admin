package com.admin.repository;

import com.admin.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAll() {
        List<ProductEntity> productList = productRepository.findAll();
        System.out.println(productList);
    }

    @Test
    public void testSave() {
        ProductEntity entity = ProductEntity.builder()
                .build();
        productRepository.save(entity);
    }

    @Test
    public void testFindLike() {
        List<ProductEntity> likeProduct = productRepository.productFind("Styli");
        System.out.println(likeProduct);
    }
}