package com.admin.service;

import com.admin.entity.*;
import com.admin.model.Category;
import com.admin.model.Product;
import com.admin.model.Review;
import com.admin.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private FileRepository fileRepository;
    @Autowired private ReviewRepository reviewRepository;

    public List<Product> getProductList() {
        List<ProductEntity> productList = productRepository.findAllNotDeleted();
        List<Product> products = new ArrayList<>();
        for (ProductEntity pe : productList) {
            CategoryEntity ce = pe.getCategory();
            Product p = Product.builder()
                    .productNo(pe.getProductNo())
                    .productName(pe.getProductName())
                    .productPrice(pe.getProductPrice())
                    .productStock(pe.getProductStock())
                    .productState(pe.getProductState())
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
                .productNo(pe.getProductNo())
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

    public List<Review> getReviewList() {
        List<ReviewEntity> reviewList = reviewRepository.findAllNotDeleted();
        List<Review> reviews = new ArrayList<>();

        for (ReviewEntity re : reviewList) {
            MemberEntity me = re.getMember();
            ProductEntity pe = re.getProduct();
            FileEntity fe = re.getFile();
            Review r = Review.builder()
                    .reviewNo(re.getReviewNo())
                    .reviewTitle(re.getReviewTitle())
                    .reviewContent(re.getReviewContent())
                    .reviewDate(re.getReviewDate())
                    .reviewStar(re.getReviewStar())
                    .memEmail(me.getMemEmail())
                    .productName(pe.getProductName())
                    .fileName(fe.getChangeName())
                    .build();
            reviews.add(r);
        }
        return reviews;
    }

    public void deleteReviews(Integer reviewNo) {

        ReviewEntity reviewEntity = reviewRepository.findById(reviewNo).orElseThrow();
        reviewEntity.setReviewState("N");
        reviewRepository.save(reviewEntity);
    }

    public void updateProduct(Product product) {
        ProductEntity productEntity = productRepository.findById(product.getProductNo()).orElseThrow();
        CategoryEntity categoryEntity = categoryRepository.findById(product.getCategoryNo()).orElseThrow();
        if (product.getFileNo() != productEntity.getFile().getFileNo()) {
            FileEntity fileEntity = fileRepository.findById(product.getFileNo()).orElseThrow();
            productEntity.setFile(fileEntity);
        }

        productEntity.setProductName(product.getProductName());
        productEntity.setProductPrice(product.getProductPrice());
        productEntity.setProductStock(product.getProductStock());
        productEntity.setCategory(categoryEntity);

        productRepository.save(productEntity);
    }

    public void deleteProduct(Integer productNo) {

        ProductEntity productEntity = productRepository.findById(productNo).orElseThrow();
        productEntity.setProductState("N");
        productRepository.save(productEntity);
    }
}
