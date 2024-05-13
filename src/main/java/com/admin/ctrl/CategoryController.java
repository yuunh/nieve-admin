package com.admin.ctrl;

import com.admin.model.Category;
import com.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/category")
    public String addCategory(@ModelAttribute Category category) {

        categoryService.addCategory(category);
        System.out.println(category);

        return "redirect:/categoryList.html";
    }

    @GetMapping("/categoryAdd")
    public String categoryAdd(Model m) {

        List<Category> categoryList = categoryService.getCategoryList();

        m.addAttribute("categoryList", categoryList);

        return "categoryAdd";
    }

    @GetMapping("/category/edit.html")
    public String categoryEdit(@RequestParam(value = "categoryNo", required = false) int categoryNo, Model m) {

        Category category = categoryService.getCategory(categoryNo);

        m.addAttribute("category", category);

        return "categoryUpdate";
    }

    @PostMapping("/categoryUpdate")
    public String categoryUpdate(@ModelAttribute Category category) {

        categoryService.updateCategory(category);

        return "redirect:/category/edit.html?&categoryNo=" + category.getCategoryNo();
    }
}
