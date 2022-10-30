package demo.controllers;

import demo.dto.CustomerUseDTO;
import demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/use")
public class CustomerUse {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String getList(Model model){
        List<CustomerUseDTO> customerDTOList = customerService.getAllCustomerUse();
        model.addAttribute("list", customerDTOList);
        return "list_customer_use";
    }
}
