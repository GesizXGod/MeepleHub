package com.meeplehub.repository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import com.meeplehub.model.Customer;
import com.meeplehub.repository.Repository;


    public class RepositoryTest {
        private Repository<Customer> repo;
        @Test
        void setRepositoryTest(){
    Repository<Customer> repository = new Repository<>();
    repository.save(new Customer(1, "Anna", false));
    repository.findById(1);
    assertNotNull(repository.findById(1));
    assertEquals(1, repository.findById(1).getId());
        }
    @Test
        void shouldUpdateCustomer(){
            Repository<Customer> repost = new Repository<>();
            repost.save(new Customer(1, "Anna", false));
            repost.save(new Customer(1, "Bob", true));
            repost.findById(1);
            assertEquals("Bob",repost.findById(1).getName());
    }
    @Test
        void shouldDeleteCustomer(){
            Repository <Customer> repo = new Repository<>();
            repo.save(new Customer(1, "Jack", false));
            repo.delete(1);
            assertNull(repo.findById(1));
    }
        @Test
        void shouldFindAllCustomers(){
            Repository <Customer> repo = new Repository<>();
            repo.save(new Customer(1, "Jack", false));
            repo.save(new Customer(2, "Kai", true));
            repo.save(new Customer(3, "Lena", false));
            assertEquals(3, repo.findAll().size());
        }
        @Test
        void shouldCountCustomers(){

            assertEquals(2, repo.count());
            repo.delete(2);
            assertEquals(1, repo.count());
        }
        @BeforeEach
        void setUp(){
            repo = new Repository<>();
            repo.save(new Customer(1, "Jack", false));
            repo.save(new Customer(2, "Kai", true));
        }
        @AfterEach
        void tearDown(){
            System.out.println("Завершение теста");

        }
        @Test
        void shouldStartWithTwoCustomers() {
            assertEquals(2, repo.count());
        }
        @BeforeAll
        static void beforeAll(){
            System.out.println("Все тесты Repository начинаются!");
        }

        @AfterAll
        static void afterAll(){
            System.out.println("Все тесты Repository завершены!");
        }

}
