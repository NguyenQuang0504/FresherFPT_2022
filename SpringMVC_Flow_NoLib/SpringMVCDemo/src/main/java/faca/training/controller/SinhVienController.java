package faca.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import faca.training.bean.SinhVien;
import faca.training.service.SinhVienService;

@Controller
public class SinhVienController {
	
	@Autowired
	private SinhVienService service;
	
	@RequestMapping("/sinhvienlist")
	public String showListSinhVien(Model model) {
		List svList = service.getListSinhVien();
		model.addAttribute("sinhVienList", svList);
		return "sinh_vien_list";
	}
	
	@RequestMapping("/showsinhvienupdate")
	public String showUpdateSinhVien(Model model, @RequestParam("sinhvienId") int sinhVienId) {
		SinhVien sv = service.getSinhVienById(sinhVienId);
		model.addAttribute("sinhvien", sv);
		return "sinh_vien_detail";
	}
	
	@RequestMapping(path = "/updateSinhVien", method = RequestMethod.POST)
	public String updateSinhVien(Model model, @ModelAttribute("sinhvien") SinhVien sv) {
		boolean resultUpdate = service.updateSinhVien(sv);
		if (!resultUpdate) {
			System.out.println("Update that bai");
		} else {
			System.out.println("Update Thanh Cong");
		}
		
		return "redirect:/sinhvienlist";
	}
}
