package faca.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import faca.training.bean.GiaoVien;
import faca.training.bean.SinhVien;
import faca.training.service.GiaoVienService;

@Controller
public class GiaoVienController {
	
	@Autowired
	private GiaoVienService service;
	
	@RequestMapping("/giaovienlist")
	public String showListGiaoVien(Model model) {
		List gvList = service.findAll();
		model.addAttribute("giaoVienList", gvList);
		return "giao_vien_list";
	}
	
	@RequestMapping("/showgiaovienupdate")
	public String showUpdateGiaoVien(Model model, @RequestParam("giaoVienId") int giaoVienId) {
		GiaoVien gv = service.findById(giaoVienId);
		model.addAttribute("giaovien", gv);
		return "giao_vien_detail";
	}
	
	@RequestMapping(path = "/updateGiaoVien", method = RequestMethod.POST)
	public String updateGiaoVien(Model model, @ModelAttribute("giaovien") GiaoVien gv) {
		service.update(gv);
		return "redirect:/giaovienlist";
	}
}
