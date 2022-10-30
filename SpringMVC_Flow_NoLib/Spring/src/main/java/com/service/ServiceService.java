package com.service;

import com.entities.PageAble;
import com.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public List<com.entities.Service> getAll() {
        return serviceRepository.getAll();
    }

    public void save(com.entities.Service serviceCreate) {
        serviceRepository.save(serviceCreate);
    }

    public void delete(String maDV) {
        serviceRepository.delete(maDV);
    }

    public com.entities.Service find(String maDV) {
        return serviceRepository.find(maDV);
    }

    public List<com.entities.Service> getAllPageAble(PageAble pageAble) {
        return serviceRepository.getAllPageAble(pageAble);
    }
    public Integer getTotalPage(PageAble pageAble){
        return (int) Math.ceil((double) getAll().size()/pageAble.getSize());
    }
}
