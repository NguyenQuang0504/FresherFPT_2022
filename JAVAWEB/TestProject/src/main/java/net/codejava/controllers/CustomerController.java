package net.codejava.controllers;

import java.util.List;
import java.util.Map;

import net.codejava.model.Customer;
import net.codejava.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {	
 
    @Autowired
    private CustomerService service;
	
	@RequestMapping("/")
    public ModelAndView home() {
    	ModelAndView mav = new ModelAndView("index");
    	
    	List<Customer> listCustomer = service.listAll();
    	
    	mav.addObject("listCustomer", listCustomer);
    	return mav;
    }
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		model.put("customer", new Customer());
		return "new_customer";
	}
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.save(customer);
		return "redirect:/"; //refresh the homepage
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		Customer customer = service.get(id);
		mav.addObject("customer", customer);
		return mav;
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam long id){
		service.deleteCustomer(id);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public String search(@RequestParam String keyword, Model model){
		System.out.println(keyword);
		List<Customer> customerList = service.findByName(keyword);
		System.out.println(customerList.toArray().toString());
		model.addAttribute("listCustomer", customerList);
		return "index";
	}
}
