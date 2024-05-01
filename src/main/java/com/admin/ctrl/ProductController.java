package com.admin.ctrl;

import com.admin.model.Product;
import com.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/edit.html")
    public String productEdit(@RequestParam(value = "productNo", required = false) int productNo, Model m){
        // select from product from product table
        Product product = new Product();
        m.addAttribute("product", product);
        return "productUpdate";
    }

    @PostMapping("/product")
    public String registerProduct(@ModelAttribute Product product){
        productService.insertProduct(product);
        System.out.println("product : " + product);
        return "redirect:/productList.html";
    }
}
