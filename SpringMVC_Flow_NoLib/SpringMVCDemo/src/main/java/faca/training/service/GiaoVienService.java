package faca.training.service;

import java.util.List;

import faca.training.bean.GiaoVien;

public interface GiaoVienService {

	public void insert(GiaoVien gv);
	
	public GiaoVien findById(int id);
	
	public List findAll();
	
	public void update(GiaoVien gv);
}
