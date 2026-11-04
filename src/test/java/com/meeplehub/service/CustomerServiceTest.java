package com.meeplehub.service;
import com.meeplehub.repository.Repository;
import com.meeplehub.model.Customer;
import com.meeplehub.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock Repository<Customer> repository;
    @InjectMocks CustomerService customerService;
    @Test
    void shouldFindCustomerThroughService(){
        Customer customer = new Customer(1, "Sasha", true);
        when(repository.findById(1))
                .thenReturn(customer);
        Customer result = customerService.findCustomer(1);
        assertEquals("Sasha", result.getName());
        verify(repository).findById(1);
    }
    @Test
    void shouldSaveCustomerThroughService(){
        Customer customer = new Customer(1, "Sasha", true);
        customerService.saveCustomer(customer);
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(repository).save(captor.capture());
        Customer cuptured = captor.getValue();
        assertEquals("Sasha", cuptured.getName());
        assertEquals(1, cuptured.getId());
    }
    @Test
    void shouldThrowExceptionWhenCustomerNotFound(){
        Customer customer = new Customer(1, "Sasha", true);
        doReturn(null)
                .when(repository)
                .findById(1);
            Customer result = repository.findById(1);
            assertThrows(RuntimeException.class, () -> customerService.findCustomer(1));
    }
    @Test
    void shouldHandleRepositoryException(){
        doThrow(new RuntimeException("Database Error"))
                .when(repository)
                .findById(1);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> customerService.findCustomer(1));
        assertEquals("Database Error", exception.getMessage());
    }
    @Test
        void shouldDoNothingInRepository(){
        Customer customer = new Customer(1, "Sasha", true);
        doNothing()
                .when(repository)
                .delete(1);
        repository.delete(1);
        verify(repository).delete(1);
    }
    @Test
    void shouldBeFirst(){
        Customer customer = new Customer(1, "Jack", false);
        when(repository.findById(1))
                .thenReturn(customer);
        Customer result = customerService.findCustomer(1);
        assertEquals("Jack", result.getName());
        verify(repository).findById(1);
    }
    @Test
    void shouldBeSecond(){
        Customer customer = new Customer(1, "Jack", false);
            when(repository.findById(1))
                    .thenReturn(null);
            assertThrows(RuntimeException.class, () -> customerService.findCustomer(1));
    }
    @Test
    void shouldBeThird(){
        Customer customer = new Customer(1, "Jack", false);
        customerService.saveCustomer(customer);
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(repository).save(captor.capture());
        Customer cuptured = captor.getValue();
       assertEquals("Jack", cuptured.getName());
    }
    @Test
    void shouldBeFourth(){
        Customer customer = new Customer(1, "Jack", false);
        customerService.deleteCustomer(1);
        verify(repository).delete(1);
    }
    @Test
    void shouldBeFifth(){
        Customer customer = new Customer(1, "Jack", false);
        customerService.deleteCustomer(1);
        verify(repository, times(1)).delete(1);
    }
    @Test
    void shouldBeSixth(){
        Customer customer = new Customer(1, "Jack", false);
        customerService.saveCustomer(customer);
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(repository).save(captor.capture());
        Customer cuptured = captor.getValue();
        assertEquals("Jack", cuptured.getName());
    }

}
