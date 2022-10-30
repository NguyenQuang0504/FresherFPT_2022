package demo.controllers;

import demo.models.Machine;
import demo.models.PageAble;
import demo.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/machine")
public class MachineController {

    @Autowired
    MachineService machineService;

//    @GetMapping("/list")
//    public String showList(@RequestParam(defaultValue = "1") Integer page,Model model){
//        List<Machine> machineList = machineService.getAll();
//        model.addAttribute("machines", machineList);
//        return "list_machine";
//    }
    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "1") Integer page,Model model){
        PageAble pageAble = new PageAble(page);
        List<Machine> machineList = machineService.getAllPageAble(pageAble);
        Integer totalPage = machineService.getTotalPage(pageAble);
        model.addAttribute("machines", machineList);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);
        return "list_machine";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("machine", new Machine());
        return "create_machine";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("machine") @Valid Machine machine, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("message", "Fail!!!");
            return "create_machine";
        }
        machineService.save(machine);
        model.addAttribute("message", "Success!!!");
        return "redirect:/machine/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String maMay){
        machineService.delete(maMay);
        return "redirect:/machine/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") String maMay, Model model){
        Machine machine = machineService.find(maMay);
        System.out.println(machine.getMaMay());
        model.addAttribute("machine", machine);
        return "update_machine";
    }
}
