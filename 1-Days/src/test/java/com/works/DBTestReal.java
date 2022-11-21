package com.works;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
public class DBTestReal {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void addTest() {
        Customer customer = new Customer();
        customer.setEmail("veli@mail.com");
        customer.setName("Veli Bilmem");
        customerRepository.save(customer);

        Assertions.assertEquals(1, customer.getCid());
    }

}
