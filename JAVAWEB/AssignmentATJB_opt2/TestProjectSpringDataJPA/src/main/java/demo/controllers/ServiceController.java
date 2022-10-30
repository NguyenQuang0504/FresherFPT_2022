package demo.controllers;
import demo.models.PageAble;
import demo.models.Service;
import demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService service;

//    @GetMapping("/list")
//    public String getAll(@RequestParam(defaultValue = "1") Integer page,Model model){
//        List<Service> list = service.getAll();
//        model.addAttribute("services", list);
//        return "list_service";
//    }
    @GetMapping("/list")
    public String getAll(@RequestParam(defaultValue = "1") Integer page,Model model){
        PageAble pageAble = new PageAble(page);
        List<Service> list = service.getAllPageAble(pageAble);
        Integer totalPage = service.getTotalPage(pageAble);
        model.addAttribute("services", list);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currentPage", page);
        return "list_service";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("service", new Service());
        return "create_service";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("service") @Valid Service serviceCreate, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("message", "Fail!!!");
            return "create_service";
        }
        service.save(serviceCreate);
        model.addAttribute("message", "Success!!!");
        return "redirect:/service/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String maDV){
        service.delete(maDV);
        return "redirect:/service/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") String maDV, Model model){
        Service serviceUpdate = service.find(maDV);
        model.addAttribute("service", serviceUpdate);
        return "update_service";
    }
}
