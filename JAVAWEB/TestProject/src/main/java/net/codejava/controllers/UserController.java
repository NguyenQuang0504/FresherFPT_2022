package net.codejava.controllers;

import net.codejava.model.Customer;
import net.codejava.model.User;
import net.codejava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String showList(Model model){
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "list_user";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        User userget = userService.getById(id);
        model.addAttribute("user", userget);
        return "edit_user";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user){
        System.out.println(user);
        userService.save(user);
        return "redirect:/user/home";
    }

    @RequestMapping("/new")
    public String createCustomer(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "create_user";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String keyword,Model model){
        List<User> user =  userService.search(keyword);
        model.addAttribute("users", user);
        return "list_user";
    }

}
