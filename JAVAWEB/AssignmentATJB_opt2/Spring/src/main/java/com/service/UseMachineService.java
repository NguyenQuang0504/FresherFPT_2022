package com.service;

import com.entities.UseMachine;
import com.repository.UseMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseMachineService {
    @Autowired
    UseMachineRepository useMachineRepository;

    public void save(UseMachine useMachine) {
        useMachineRepository.save(useMachine);
    }

    public List<UseMachine> getAll() {
        return useMachineRepository.getAll();
    }
}
