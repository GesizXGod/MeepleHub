package com.meeplehub.model;
import com.meeplehub.repository.Repository;
import com.meeplehub.model.Customer;
import com.meeplehub.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;

@ExtendWith(MockitoExtension.class)

public class MockitoTest {
    @Mock
    Repository<Customer> repository;
    @InjectMocks
    CustomerService customerService;
    @Test
    void shouldFindCustomer(){
        Customer customer = new Customer(1, "Jack", false);
        when(repository.findById(1))
                .thenReturn(customer);
        Customer result = repository.findById(1);
        assertEquals(false, result.isVip());
    }
    @Test
    void shouldFindCustomerThroughService(){
        Customer customer = new Customer(1, "Jack", false);
        when(repository.findById(1))
                    .thenReturn(customer);
        Customer result = customerService.findCustomer(1);
            assertEquals("Jack", result.getName());
            verify(repository, times(1)).findById(1);
        }
        @Test
        void shouldSaveCustomerThroughService(){
        Customer customer = new Customer(1, "Jack", false);
            customerService.saveCustomer(customer);
         ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
         verify(repository).save(captor.capture());
         Customer captured = captor.getValue();
         assertEquals("Jack", captured.getName());

        }
    }




