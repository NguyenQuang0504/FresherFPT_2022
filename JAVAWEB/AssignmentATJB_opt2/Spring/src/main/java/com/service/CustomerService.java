package com.service;

import com.entities.Customer;
import com.entities.PageAble;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.getAll();
    }

    public void delete(String maKH) {
        customerRepository.delete(maKH);
    }

    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    public Customer findById(String maKH) {
       return customerRepository.find(maKH);
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public List<Customer> getAllPageAble(PageAble pageAble) {
        return customerRepository.getAllPageAble(pageAble);
    }

    public Integer getTotalPage(PageAble pageAble) {
        return (int)Math.ceil((double)getAll().size()/pageAble.getSize());
    }
}
