package com.admin.ctrl;

import com.admin.model.Category;
import com.admin.model.Member;
import com.admin.model.Product;
import com.admin.service.CategoryService;
import com.admin.service.MemberService;
import com.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    @GetMapping("categoryList.html")
    public String categoryList(Model m) {

        List<Category> categoryList = categoryService.getCategoryList();

        m.addAttribute("categoryList", categoryList);

        return "categoryList";
    }

}
