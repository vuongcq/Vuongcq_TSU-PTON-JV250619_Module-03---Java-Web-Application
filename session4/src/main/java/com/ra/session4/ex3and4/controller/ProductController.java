package com.ra.session4.ex3and4.controller;

import com.ra.session4.ex3and4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listProduct")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProduct(Model model) {
        model.addAttribute("products", productService.getListProduct());
        return "listProducts";
    }

    @GetMapping("/search")
    public String searchProduct(String searchProductName,Model model) {
        model.addAttribute("products", productService.searchProductsByName(searchProductName));
        model.addAttribute("keyword", searchProductName); // giữ từ khóa trong input
        return "listProducts"; // hiển thị ra listProducts
    }
}
