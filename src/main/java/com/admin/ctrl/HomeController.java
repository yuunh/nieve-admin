package com.admin.ctrl;

import com.admin.model.*;
import com.admin.service.CategoryService;
import com.admin.service.MemberService;
import com.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/productList.html")
    public String productList(Model m) {

        List<Product> productList = productService.getProductList();

        m.addAttribute("productList", productList);

        return "productList";
    }

    @GetMapping("/memberList.html")
    public String memberList(Model m) {

        List<Member> memberList = memberService.getMemberList();

        m.addAttribute("memberList", memberList);

        return "memberList";
    }

    @GetMapping("/orderList.html")
    public String orderList(Model m) {

        List<ProductOrder> orderList = productService.getOrderList();

        m.addAttribute("orderList", orderList);

        return "orderList";
    }

    @GetMapping("categoryList.html")
    public String categoryList(Model m) {

        List<Category> categoryList = categoryService.getCategoryList();

        m.addAttribute("categoryList", categoryList);

        return "categoryList";
    }

    @GetMapping("/reviewManagement.html")
    public String reviewManagement(Model m) {

        List<Review> reviewList = productService.getReviewList();

        m.addAttribute("reviewList", reviewList);

        return "reviewManagement";
    }

    @PostMapping("/deleteReviews")
    @ResponseBody
    public Map<String, Object> deleteReviews(@RequestBody Integer[] reviewNos) {
        for(Integer reviewNo : reviewNos){
            System.out.println("reivew No : " + reviewNo);

            productService.deleteReviews(reviewNo);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("code", "OK");
        return res;
    }

}
