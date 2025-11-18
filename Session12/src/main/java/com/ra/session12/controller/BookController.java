package com.ra.session12.controller;

import com.ra.session12.model.dto.BookDTO;
import com.ra.session12.model.entity.Book;
import com.ra.session12.model.entity.Customer;
import com.ra.session12.service.BookService;
import com.ra.session12.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String books(Model model, RedirectAttributes redirectAttributes) {
        Customer customerLogin = customerService.getInfoCustomerLogin();
        if (customerLogin == null) {
            redirectAttributes.addFlashAttribute("message", "Bạn vui lòng đăng nhập trước nhé");
            return "redirect:/auth/login";
        }
        model.addAttribute("books", bookService.findAll());
        return "/book/books";
    }

    @GetMapping("/add")
    public String addBook(Model model, RedirectAttributes redirectAttributes) {
        Customer customerLogin = customerService.getInfoCustomerLogin();
        if (customerLogin == null) {
            redirectAttributes.addFlashAttribute("message", "Bạn vui lòng đăng nhập trước nhé");
            return "redirect:/auth/login";
        }

        model.addAttribute("book", new BookDTO());
        return "/book/addBook";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult bindingResult
            , Model model, RedirectAttributes redirectAttributes){
        if (bookDTO.getImage() == null || bookDTO.getImage().isEmpty()){
            bindingResult.rejectValue("image", "error.image", "Image is required");
        }
        if (bindingResult.hasErrors()) {
            return "/book/addBook";
        }

        Book book = bookService.save(bookDTO);
        if (book != null){
            redirectAttributes.addFlashAttribute("message", "Book added successfully");
            return "redirect:/books";
        }else {
            model.addAttribute("message", "Book added failed");
            model.addAttribute("book", bookDTO);
            return "/book/addBook";
        }
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Customer customerLogin = customerService.getInfoCustomerLogin();
        if (customerLogin == null) {
            redirectAttributes.addFlashAttribute("message", "Bạn vui lòng đăng nhập trước nhé");
            return "redirect:/auth/login";
        }

        Book book = bookService.findBookById(id);
        BookDTO bookDTO = bookService.convertBookToBookDTO(book);
        model.addAttribute("book", bookDTO);
        model.addAttribute("image" , book.getImage());
        model.addAttribute("id",id);
        return "/book/editBook";

    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable long id , @Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model){
        Book book = bookService.findBookById(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", bookDTO);
            model.addAttribute("image" , book.getImage());
            model.addAttribute("id",id);
            return "/book/editBook";
        }

        Book newBook = bookService.updateBook(bookDTO,id);
        if (newBook != null){
            redirectAttributes.addFlashAttribute("message", "Book updated successfully");
            return "redirect:/books";
        }else {
            model.addAttribute("message", "Book updated failed");
            model.addAttribute("book", bookDTO);
            model.addAttribute("id",id);
            model.addAttribute("image" , book.getImage());
            return "/book/editBook";
        }
    }
}
