package com.meeplehub.service;

import com.meeplehub.repository.Repository;
import com.meeplehub.model.Customer;

public class CustomerService {
    private final Repository<Customer> repository;
    public CustomerService(Repository<Customer> repository){
        this.repository = repository;
    }
    public Customer findCustomer(long id){
        return repository.findById(id);
    }
    public void saveCustomer(Customer customer){
        repository.save(customer);
    }

}
