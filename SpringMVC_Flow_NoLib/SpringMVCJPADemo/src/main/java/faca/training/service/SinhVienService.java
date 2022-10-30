package faca.training.service;

import java.util.List;

import faca.training.bean.SinhVien;

public interface SinhVienService {

	public List getListSinhVien();
	
	public SinhVien getSinhVienById(int id);
	
	public boolean updateSinhVien(SinhVien sv);
}
