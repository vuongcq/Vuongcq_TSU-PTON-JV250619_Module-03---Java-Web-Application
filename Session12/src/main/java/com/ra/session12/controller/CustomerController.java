package com.ra.session12.controller;

import com.ra.session12.model.dto.CustomerDTO;
import com.ra.session12.model.dto.CustomerLoginDTO;
import com.ra.session12.model.entity.Customer;
import com.ra.session12.model.entity.CustomerLogin;
import com.ra.session12.model.entity.Role;
import com.ra.session12.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        return "/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(Model model, @Valid @ModelAttribute("customer") CustomerDTO customerDTO,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customerDTO);
            return "/auth/register";
        }

        Customer customer = customerService.register(customerDTO);
        if (customer == null) {
            redirectAttributes.addFlashAttribute("message", "register failed");
            model.addAttribute("customer", customerDTO);
            return "/auth/register";
        }else {
            redirectAttributes.addFlashAttribute("message", "register successful");
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String login(Model model ) {
        model.addAttribute("customer", new CustomerLoginDTO());
        return "/auth/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("customer") CustomerLoginDTO customerLogin, BindingResult bindingResult
            , RedirectAttributes redirectAttributes, Model model , HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customerLogin);
            return "/auth/login";
        }

       Customer customer = customerService.login(customerLogin);
       if (customer == null) {
          model.addAttribute("message", "Username or password is incorrect");
          model.addAttribute("customer", customerLogin);
          return "/auth/login";

       }else {
           CustomerLogin.customer = customer;
           if(customer.getRole().equals(Role.ADMIN)) {
               redirectAttributes.addFlashAttribute("message", "Login successful");
               return "redirect:/books";
           }else {
               redirectAttributes.addFlashAttribute("message", "Login successful");
               return "redirect:/home";
           }
       }

    }
}
