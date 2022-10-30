package com.service;

import com.entities.Machine;
import com.entities.PageAble;
import com.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    @Autowired
    MachineRepository machineRepository;

    public List<Machine> getAll() {
        return  machineRepository.getAll();
    }

    public void save(Machine machine) {
        machineRepository.save(machine);
    }

    public void delete(String maMay) {
        machineRepository.delete(maMay);
    }

    public Machine find(String maMay) {
        return machineRepository.find(maMay);
    }

    public List<Machine> getAllPageAble(PageAble pageAble) {
        return machineRepository.getAllPageAble(pageAble);
    }

    public Integer getTotalPage(PageAble pageAble) {
        return (int)Math.ceil((double) getAll().size()/pageAble.getSize());
    }
}
