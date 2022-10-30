package demo.service;
import demo.dto.CustomerUseDTO;
import demo.models.Customer;
import demo.models.PageAble;
import demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public void delete(String maKH) {
        customerRepository.deleteById(maKH);
    }

    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findById(String maKH) {
       return customerRepository.find(maKH);
    }

    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    public Integer getTotalPage(PageAble pageAble) {
        return (int)Math.ceil((double)getAll().size()/pageAble.getSize());
    }

    public List<Customer> getAllPageAble(PageAble pageAble) {
        return customerRepository.findAllPageAble((pageAble.getCurrent()-1)*pageAble.getSize(), pageAble.getSize());
    }

    public List<CustomerUseDTO> getAllCustomerUse() {
        return customerRepository.getAllCustomerUse();
    }
}
