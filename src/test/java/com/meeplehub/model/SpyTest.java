package com.meeplehub.model;
import com.meeplehub.repository.Repository;
import com.meeplehub.model.Customer;
import com.meeplehub.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;

@ExtendWith(MockitoExtension.class)
public class SpyTest {
    @Test
    void shouldFindJackThroughSpy() {
        Repository<Customer> repository = new Repository<>();
        Customer customer = new Customer(1, "Jack", false);
        repository.save(customer);
        Repository<Customer> spyRepository = spy(repository);
        assertEquals("Jack", spyRepository.findById(1).getName());
        doReturn(null)
                .when(spyRepository)
                .findById(1);
        assertNull(spyRepository.findById(1));
    }
    @Test
    void shouldFindJackThroughSpai() {
        Repository<Customer> repository = new Repository<>();
        Customer customer = new Customer(1, "Jack", false);
        repository.save(customer);
        Repository<Customer> spyRepository = spy(repository);
        doNothing()
                .when(spyRepository)
                .delete(1);
        spyRepository.delete(1);
        assertEquals("Jack", spyRepository.findById(1).getName());
    }

}
