package com.admin.ctrl;

import com.admin.model.Category;
import com.admin.model.Product;
import com.admin.service.CategoryService;
import com.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/productAdd")
    public String productAdd(Model m) {

        List<Category> categoryList = categoryService.getCategoryList();

        m.addAttribute("categoryList", categoryList);

        return "productAdd";
    }

    @GetMapping("/product/edit.html")
    public String productEdit(@RequestParam(value = "productNo", required = false) int productNo, Model m) {
        // select from product from product table
        Product product = new Product();
        m.addAttribute("product", product);
        return "productUpdate";
    }

    @PostMapping("/product")
    public String registerProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        System.out.println("product : " + product);
        return "redirect:/productList.html";
    }


}
