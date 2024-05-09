package com.admin.ctrl;

import com.admin.entity.ProductEntity;
import com.admin.model.Product;
import com.admin.service.CategoryService;
import com.admin.service.ProductService;
import com.admin.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    StorageService storageService;

    @PostMapping("/product")
    public String registerProduct(@ModelAttribute Product product, @RequestParam("productImg") MultipartFile productImg) {

        int fileNo = storageService.store(productImg);
        product.setFileNo(fileNo);
        productService.addProduct(product);
        System.out.println("product : " + product);


        return "redirect:/productList.html";
    }
    @GetMapping("/productAdd")
    public String productAdd(Model m) {

        List<Product> productList = productService.getProductList();

        m.addAttribute("categoryList", categoryService.getCategoryList());
        m.addAttribute("productList", productList);

        return "productAdd";
    }

    @GetMapping("/product/edit.html")
    public String productEdit(@RequestParam(value = "productNo", required = false) int productNo, Model m) {

        Product product = productService.getProduct(productNo);

        m.addAttribute("product", product);
        m.addAttribute("categoryList", categoryService.getCategoryList());

        return "productUpdate";
    }

    @PostMapping("/productUpdate")
    public String productUpdate(@ModelAttribute Product product, @RequestParam(value = "productImg", required = false) MultipartFile productImg) {

        if (productImg != null && !productImg.isEmpty()) {
            int fileNo = storageService.store(productImg);
            product.setFileNo(fileNo);
        }

        productService.updateProduct(product);

        return "redirect:/product/edit.html?&productNo=" + product.getProductNo();
    }
}
