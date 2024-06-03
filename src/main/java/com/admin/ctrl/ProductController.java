package com.admin.ctrl;

import com.admin.model.Product;
import com.admin.model.ProductOrder;
import com.admin.service.CategoryService;
import com.admin.service.ProductService;
import com.admin.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    StorageService storageService;

    @PostMapping("/product")
    public String registerProduct(@ModelAttribute Product product,
                                  @RequestParam("productImg1") MultipartFile productImg1,
                                  @RequestParam("productImg2") MultipartFile productImg2,
                                  @RequestParam("productImg3") MultipartFile productImg3) {

        int fileNo1 = storageService.store(productImg1);
        int fileNo2 = storageService.store(productImg2);
        int fileNo3 = storageService.store(productImg3);

        product.setFileNo1(fileNo1);
        product.setFileNo2(fileNo2);
        product.setFileNo3(fileNo3);
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
    public String productUpdate(@ModelAttribute Product product,
                                @RequestParam(value = "productImg1", required = false) MultipartFile productImg1,
                                @RequestParam(value = "productImg2", required = false) MultipartFile productImg2,
                                @RequestParam(value = "productImg3", required = false) MultipartFile productImg3) {

        if (productImg1 != null && !productImg1.isEmpty()) {
            int fileNo1 = storageService.store(productImg1);
            product.setFileNo1(fileNo1);
        }
        if (productImg2 != null && !productImg2.isEmpty()) {
            int fileNo2 = storageService.store(productImg2);
            product.setFileNo2(fileNo2);
        }
        if (productImg3 != null && !productImg3.isEmpty()) {
            int fileNo3 = storageService.store(productImg3);
            product.setFileNo3(fileNo3);
        }

        productService.updateProduct(product);

        return "redirect:/product/edit.html?&productNo=" + product.getProductNo();
    }

    @PostMapping("/deleteProduct")
    @ResponseBody
    public Map<String, Object> deleteProduct(@RequestBody Integer[] productNos) {
        for(Integer productNo : productNos){
            System.out.println("product No : " + productNo);

            productService.deleteProduct(productNo);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("code", "OK");
        return res;
    }

    @GetMapping("/orderModify.html")
    public String orderModify(@RequestParam(value = "orderNo", required = false) int orderNo, Model m) {

        ProductOrder order = productService.gerOrder(orderNo);
        m.addAttribute("order", order);

        List<String> orderStates = Arrays.asList("주문", "결제완료", "상품준비", "배송중", "배송완료");
        m.addAttribute("orderStates", orderStates);
        return "orderModify";
    }

    @PostMapping("/orderModify")
    public String orderModify(@ModelAttribute ProductOrder order, RedirectAttributes redirectAttributes) {

        productService.modifyOrder(order);

        redirectAttributes.addFlashAttribute("message", "수정이 완료되었습니다.");

        return "redirect:/orderModify.html?&orderNo=" + order.getOrderNo();
    }


}
