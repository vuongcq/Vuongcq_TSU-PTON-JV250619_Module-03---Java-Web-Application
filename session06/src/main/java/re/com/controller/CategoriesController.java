package re.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.com.model.Categories;
import re.com.service.CategoriesService;

import java.util.List;

@Controller
@RequestMapping("/catalogController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/findAll")
    public String findAllCategories(Model model) {
        List<Categories> listCategories = categoriesService.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/initCreate")
    public String initCreateCatalog(Model model) {
        Categories catalog = new Categories();
        model.addAttribute("catalog", catalog);
        return "newCatalog";
    }

    @PostMapping("/create")
//    public String createCatalog(@ModelAttribute("catalog") Categories catalog1) {
    public String createCatalog(Categories catalog) {
        boolean result = categoriesService.create(catalog);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
//    public String initUpdateCatalog(Model model,@RequestParam("catalogId") int id) {
    public String initUpdateCatalog(Model model, int catalogId) {
        Categories catalog = categoriesService.findById(catalogId);
        model.addAttribute("catalog", catalog);
        return "updateCatalog";
    }

    @PostMapping("/update")
    public String updateCatalog(Categories catalog) {
        boolean result = categoriesService.update(catalog);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/delete")
    public String deleteCatalog(int catalogId) {
        boolean result = categoriesService.delete(catalogId);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
}
