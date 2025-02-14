package com.example.EasyLearn.controller;


import com.example.EasyLearn.model.Customer;
import com.example.EasyLearn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String  customerList(Model model){
       List<Customer> customers = customerService.findAll();
         model.addAttribute("customers", customers);

         return "customer/customers-list";
    }

    @GetMapping("/show-add-form")
    public String showForm (Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/customer-form";
    }

    @GetMapping("/showupdateform")
    public String showUpdateForm (@RequestParam("custId") long id, Model model) {
        Customer customer = customerService.findCustomer(id);
        model.addAttribute("customer", customer);
        return "customer/customer-form";
    }
    @PostMapping ("/save")
    public String saveCustomer (@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/deletecustomer")
    public String deleteCustomer(@RequestParam("custId") long id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

}
