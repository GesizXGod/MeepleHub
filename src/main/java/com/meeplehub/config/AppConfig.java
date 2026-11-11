package com.meeplehub.config;
import com.meeplehub.model.Customer;
import com.meeplehub.repository.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.meeplehub.service")
public class AppConfig {

    @Bean
    public Repository<Customer> repository(){ return new Repository<>();}


}
