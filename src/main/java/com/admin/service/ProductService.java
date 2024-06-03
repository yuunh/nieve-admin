package com.admin.service;

import com.admin.entity.*;
import com.admin.model.Category;
import com.admin.model.Product;
import com.admin.model.ProductOrder;
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
    @Autowired private OrderRepository orderRepository;
    @Autowired private MemberRepository memberRepository;

    public List<Product> getProductList() {

        List<ProductEntity> productList = productRepository.findAllNotDeleted();

        List<Product> products = new ArrayList<>();
        for (ProductEntity pe : productList) {
            products.add(pe.toModel());
        }

        return products;
    }

    public void addProduct(Product product) {
        CategoryEntity category = categoryRepository.findById(product.getCategoryNo()).orElseThrow();
        FileEntity file1 = fileRepository.findById(product.getFileNo1()).orElseThrow();
        FileEntity file2 = fileRepository.findById(product.getFileNo2()).orElseThrow();
        FileEntity file3 = fileRepository.findById(product.getFileNo3()).orElseThrow();
        ProductEntity entity = ProductEntity.builder()
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productStock(product.getProductStock())
                .file1(file1)
                .file2(file2)
                .file3(file3)
                .category(category)
                .productState("Y")
                .build();
        productRepository.save(entity);
    }


    public Product getProduct(int productNo) {

        ProductEntity pe = productRepository.findById(productNo).orElseThrow();

        return pe.toModel();
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
        if (product.getFileNo1() != null && product.getFileNo1() != productEntity.getFile1().getFileNo()) {
            FileEntity fileEntity = fileRepository.findById(product.getFileNo1()).orElseThrow();
            productEntity.setFile1(fileEntity);
        }
        if (product.getFileNo2() != null && product.getFileNo2() != productEntity.getFile2().getFileNo()) {
            FileEntity fileEntity = fileRepository.findById(product.getFileNo2()).orElseThrow();
            productEntity.setFile2(fileEntity);
        }
        if (product.getFileNo3() != null && product.getFileNo3() != productEntity.getFile3().getFileNo()) {
            FileEntity fileEntity = fileRepository.findById(product.getFileNo3()).orElseThrow();
            productEntity.setFile3(fileEntity);
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

    public List<ProductOrder> getOrderList() {

        List<ProductOrderEntity> orderList = orderRepository.findAll();

        List<ProductOrder> orders = new ArrayList<>();
        for (ProductOrderEntity oe : orderList) {
            MemberEntity me = oe.getMember();
            ProductEntity pe = oe.getProduct();
            ProductOrder o = ProductOrder.builder()
                    .orderNo(oe.getOrderNo())
                    .memEmail(me.getMemEmail())
                    .productName(pe.getProductName())
                    .productPrice(pe.getProductPrice())
                    .orderState(oe.getOrderState())
                    .build();
            orders.add(o);
        }
        return orders;
    }

    public ProductOrder gerOrder(int orderNo) {

        ProductOrderEntity oe = orderRepository.findById(orderNo).orElseThrow();

        MemberEntity me = oe.getMember();
        ProductEntity pe = oe.getProduct();
        ProductOrder o = ProductOrder.builder()
                .orderNo(oe.getOrderNo())
                .memName(me.getMemName())
                .productName(pe.getProductName())
                .phone(oe.getPhone())
                .address(oe.getAddress())
                .message(oe.getMessage())
                .totalPrice(oe.getTotalPrice())
                .orderState(oe.getOrderState())
                .build();
        return o;
    }

    public void modifyOrder(ProductOrder order) {

        ProductOrderEntity oe = orderRepository.findById(order.getOrderNo()).orElseThrow();

        oe.setOrderState(order.getOrderState());

        orderRepository.save(oe);
    }
}
