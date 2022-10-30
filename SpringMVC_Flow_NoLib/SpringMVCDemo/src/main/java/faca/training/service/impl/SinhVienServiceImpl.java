package faca.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import faca.training.bean.SinhVien;
import faca.training.service.SinhVienService;

@Service
public class SinhVienServiceImpl implements SinhVienService {

	@Override
	public List getListSinhVien() {
		// Select list sinh vien tu database
		// Duoi day la code gia, tao ra mac dinh mot list sinh vien
		List<SinhVien> svList = new ArrayList<SinhVien>();
		
		for (int i = 0; i <= 10; i++) {
			SinhVien sv = new SinhVien();
			sv.setId(i + 1);
			sv.setName("Ho Ten Sinh Vien " + (i+1));
			sv.setAge((i+1)*10);
			svList.add(sv);
		}
		return svList;
	}

	@Override
	public SinhVien getSinhVienById(int id) {
		// Select sinh vien tu database thong qua ID
		// Duoi day la code gia, tao ra mac dinh mot sinh vien da duoc select tu DB
		SinhVien sv = new SinhVien();
		sv.setId(id);
		sv.setName("Ho Ten Sinh Vien 1");
		sv.setAge(10);
		return sv;
	}

	@Override
	public boolean updateSinhVien(SinhVien sv) {
		// Update sinh vien vao database
		//Duoi day la code gia, mac dinh la update thanh cong
		
		return true;
	}
	
	
	
	
}
