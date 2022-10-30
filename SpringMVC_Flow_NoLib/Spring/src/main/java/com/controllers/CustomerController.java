package com.controllers;

import com.entities.Customer;
import com.entities.PageAble;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "1") Integer page,Model model){
        PageAble pageAble = new PageAble(page);
        Integer totalPage = customerService.getTotalPage(pageAble);
        List<Customer> list = customerService.getAllPageAble(pageAble);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("customers", list);
        return "list_customer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String maKH, Model model){
        System.out.println(maKH);
        customerService.delete(maKH);
        return "redirect:/customer/list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "create_customer";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create_customer";
        }
        customerService.add(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id") String maKH, Model model){
        Customer customer = customerService.findById(maKH);
        model.addAttribute("customer", customer);
        return "update_customer";
    }
    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        System.out.println(customer.toString());
        customerService.update(customer);
        return "redirect:/customer/list";
    }
}
