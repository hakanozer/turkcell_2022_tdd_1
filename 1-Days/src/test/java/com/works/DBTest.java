package com.works;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DBTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @DisplayName("Customer Add JPA")
    @Order(2)
    public void addTest() {
        Customer customer = new Customer();
        customer.setEmail("veli@mail.com");
        customer.setName("Veli Bilmem");
        customerRepository.save(customer);

        Assertions.assertEquals(1, customer.getCid());
    }

    @Test
    @DisplayName("Customer List")
    @Order(1)
    public void listTest() {
        Customer customer = new Customer();
        customer.setEmail("veli@mail.com");
        customer.setName("Veli Bilmem");
        customerRepository.save(customer);

        List<Customer> list = customerRepository.findAll();
        Assertions.assertEquals(1, list.size());
    }

    public void addSample() {
        Customer customer = new Customer();
        customer.setEmail("veli@mail.com");
        customer.setName("Veli Bilmem");
        customerRepository.save(customer);
    }

    @Test
    @Order(3)
    public void sample() {
        System.out.println("sample call");
    }

}
