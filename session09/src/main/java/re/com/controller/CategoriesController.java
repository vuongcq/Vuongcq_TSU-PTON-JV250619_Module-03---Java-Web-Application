package re.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.com.model.Categories;
import re.com.service.CategoriesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    private static final int SIZE = 3;

    public List<Integer> getPages() {
        //7/3--> 3 trang
        int totalPages = (int) Math.ceil((double) categoriesService.findAll().size() / (float)SIZE);
        List<Integer> listPages = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            //{1,2,3}
            listPages.add(i);
        }
        return listPages;
    }

    @GetMapping("/findAll")
    public String findAllCategories(Model model, int page) {
        List<Categories> listCategories = categoriesService.findByPage(page, SIZE);
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("listPages", getPages());
        return "categories";
    }



    @GetMapping("initCreate")
    public String initCreateCatalog(Model model) {
        Categories catalog = new Categories();
        model.addAttribute("catalog", catalog);
        return "newCatalog";
    }

    @PostMapping("create")
    public String createCatalog(Categories catalog) {
        boolean result = categoriesService.create(catalog);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }
}
