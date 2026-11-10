package com.meeplehub.service;

import com.meeplehub.repository.Repository;
import com.meeplehub.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final Repository<Customer> repository;
    public CustomerService(Repository<Customer> repository){
        this.repository = repository;
    }
    public Customer findCustomer(long id){
        Customer customer = repository.findById(id);
        if(customer == null)
        {throw new RuntimeException("Customer not found");
        }
        return customer;
    }
    public void saveCustomer(Customer customer){
        repository.save(customer);
    }
    public void deleteCustomer(long id){
        repository.delete(id);
    }

}
