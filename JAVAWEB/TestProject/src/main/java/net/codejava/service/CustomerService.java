package net.codejava.service;

import java.util.List;
import java.util.Optional;

import net.codejava.model.Customer;
import net.codejava.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> listAll() {
		return (List<Customer>) repo.findAll();
	}
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public Customer get(long id) {
		Optional<Customer> result = repo.findById(id);
		
		return result.get();
	}

    public void deleteCustomer(long id) {
		repo.deleteById(id);
    }

    public List<Customer> findByName(String keyword) {
		return repo.findByName(keyword);
    }

//	public void deleteByName(){
//		repo.fin
//	}
}
