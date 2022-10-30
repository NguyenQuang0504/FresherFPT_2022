package demo.controllers;
import demo.models.Customer;
import demo.models.Machine;
import demo.models.UseMachine;
import demo.service.CustomerService;
import demo.service.MachineService;
import demo.service.UseMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/useMachine")
public class UseMachineController {
    @Autowired
    UseMachineService useMachineService;

    @Autowired
    MachineService machineService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/create")
    public String createMachine(Model model){
        List<Machine> machineList = machineService.getAll();
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customers", customerList);
        model.addAttribute("machines", machineList);
        model.addAttribute("useMachine", new UseMachine());
        return "use_machine";
    }

    @PostMapping("/save")
    public String saveMachine(@ModelAttribute("useMachine") UseMachine useMachine){
        System.out.println(useMachine.toString());
        useMachineService.save(useMachine);
        return "redirect:/useMachine/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<UseMachine> list = useMachineService.getAll();
        model.addAttribute("useMachines", list);
        return "list_use_machine";
    }
}
