package re.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.com.service.ProductService;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public String findAllProducts(Model model) {
        model.addAttribute("listProducts", productService.findAll());
        return "products";
    }
}
