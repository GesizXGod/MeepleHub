package com.meeplehub;

import com.meeplehub.config.AppConfig;
import com.meeplehub.model.Customer;
import com.meeplehub.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
       try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){
        CustomerService customerService = context.getBean(CustomerService.class);
        Customer customer = new Customer(1, "Alex", true);
        customerService.saveCustomer(customer);
        Customer foundCustomer = customerService.findCustomer(1);
        System.out.println(foundCustomer.getName());
       }


    }


}
