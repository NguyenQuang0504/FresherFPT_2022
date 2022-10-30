package net.codejava.repository;

import net.codejava.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "SELECT * FROM Customer WHERE name LIKE %?1% ", nativeQuery = true)
    List<Customer> findByName(String keyword);
}
