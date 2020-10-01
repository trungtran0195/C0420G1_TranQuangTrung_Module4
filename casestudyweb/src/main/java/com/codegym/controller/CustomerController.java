package com.codegym.controller;

import com.codegym.Model.Customer;
import com.codegym.Service.CustomerService;
import com.codegym.Service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Qualifier("CustomerServiceImpl")
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/customerList")
    public ModelAndView listCustomers(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search) {
        Page<Customer> customers = customerService.findAllByName(pageable,search);
        if (customers.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView("customer/customerList", "message", "Không tìm thấy danh sách customer trong DB");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("customer/customerList");
            modelAndView.addObject("customers", customers);
            modelAndView.addObject("search",search);
            return modelAndView;
        }
    }

    @GetMapping("/addCustomer")
    public ModelAndView showInfoCustomerInputForm() {
        ModelAndView modelAndView = new ModelAndView("customer/addCustomer");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("customerType",customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/addCustomer")
    public ModelAndView addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/addCustomer");
            modelAndView.addObject("customerType",customerTypeService.findAll());
            return modelAndView;
        }else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("customer/addCustomer");
            modelAndView.addObject("message", "New customer added successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable String id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("customerType",customerTypeService.findAll());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/customerList";
    }

    //    @GetMapping("/delete-customer/{id}")
//    public ModelAndView showDeleteForm(@PathVariable String id){
//        Customer customer = customerService.findById(id);
//        if(customer != null) {
//            ModelAndView modelAndView = new ModelAndView("customer/delete");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
}
