package faca.training.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import faca.training.bean.GiaoVien;
import faca.training.service.GiaoVienService;

@Service
@Transactional
public class GiaoVienServiceImpl implements GiaoVienService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(GiaoVien gv) {
		entityManager.persist(gv);
	}
	
	public GiaoVien findById(int id) {
		return entityManager.find(GiaoVien.class, id);
	}
	
	public List findAll() {
		return entityManager.createQuery("FROM GiaoVien", GiaoVien.class).getResultList();
	}
	
	public void update(GiaoVien gv) {
		GiaoVien currentValue = findById(gv.getId());
		currentValue.setName(gv.getName());
		currentValue.setAddress(gv.getAddress());
		entityManager.merge(gv);
	}
}
