package com.ra.session7.controller;

import com.ra.session7.model.entity.Category;
import com.ra.session7.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "listCategories";
    }

   @GetMapping("/initAdd")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
   }

   @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category, Model model, RedirectAttributes redirectAttributes) {
        if (category.getCateName() == null || category.getCateName().isEmpty()) {
            model.addAttribute("category", category);
            model.addAttribute("error", "Tên danh mục không được để tróng");
            return "addCategory";
        } else if (categoryService.existsByCateName(category.getCateName())) {
            model.addAttribute("category", category);
            model.addAttribute("error", "Tên danh mục đã tồn tại.");
            return "addCategory";
        }
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("messenger","Thêm danh mục thành công!");
        return "redirect:/categories";
   }

}
