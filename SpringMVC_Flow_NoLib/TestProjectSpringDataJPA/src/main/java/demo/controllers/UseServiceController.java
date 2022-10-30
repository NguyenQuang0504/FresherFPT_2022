package demo.controllers;

import demo.models.Customer;
import demo.models.Service;
import demo.models.UseService;
import demo.service.CustomerService;
import demo.service.ServiceService;
import demo.service.UseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/useService")
public class UseServiceController {
    @Autowired
    UseServiceService serviceService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceService service;

    @GetMapping("/create")
    public String createService(Model model){
        List<Service> serviceList = service.getAll();
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("services",serviceList);
        model.addAttribute("customers", customerList);
        model.addAttribute("useService", new UseService());
        return "use_service";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("useService") UseService useService){
        serviceService.save(useService);
        return "redirect:/useService/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<UseService> useServiceList = serviceService.getAll();
        model.addAttribute("useServices", useServiceList);
        return "list_use_service";
    }
}
