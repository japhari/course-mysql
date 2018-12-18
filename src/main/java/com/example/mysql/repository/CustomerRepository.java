package com.example.mysql.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.mysql.model.Customer;
 
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
}