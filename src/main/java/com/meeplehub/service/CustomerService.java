package com.meeplehub.service;

import com.meeplehub.repository.Repository;
import com.meeplehub.model.Customer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    private final Repository<Customer> repository;
    private final ObjectProvider<ReportGenerator> provider;
    public CustomerService(Repository<Customer> repository, ObjectProvider<ReportGenerator> provider){
        this.repository = repository;
        this.provider = provider;
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
    @PostConstruct
    public void init() {
        System.out.println("CustomerService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CustomerService destroyed");
    }

    public void generateReport(){
           ReportGenerator generator = provider.getObject();
           generator.generate();
    }
}

