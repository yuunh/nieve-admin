package com.admin.repository;

import com.admin.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from product p where p.productName like %:pn%")
    List<ProductEntity> productFind(@Param("pn") String productName);

    @Query("select p from product as p where p.productState = 'Y'")
    List<ProductEntity> findAllNotDeleted();
}
