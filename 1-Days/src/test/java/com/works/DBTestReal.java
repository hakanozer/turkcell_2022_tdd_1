package com.works;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DBTestReal {

    @Autowired
    CustomerRepository customerRepository;

    List<Customer> customers = new ArrayList<>();
    @BeforeAll
    public void beforeAll() {
        customers = customerRepository.findAll();
    }

    @Test
    public void nullTest() {
        Assertions.assertNotNull(customerRepository);
    }

    @Test
    public void addTest() {

        customers = customerRepository.findAll();
        Customer oldCustomer = customers.get( customers.size() - 1 );

        Customer customer = new Customer();
        customer.setEmail("veli@mail.com");
        customer.setName("Veli Bilmem");
        customerRepository.save(customer);

        Assertions.assertEquals(oldCustomer.getCid() + 1, customer.getCid());
    }

    @Test
    public void listTest() {
        Assertions.assertNotEquals(0, customers.size());
    }

    @Test
    public void emailControl() {
        List<Customer> list = customerRepository.findByEmailEqualsIgnoreCase("veli@mail.com");
        Assertions.assertEquals(2, list.get(0).getCid() );
    }

    @Test
    public void findTest() {
        String q = "veli";
        List<Customer> findCustomer = customerRepository.findCustomer(q, q);
        Assertions.assertNotEquals(0, findCustomer.size());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"veli", "bilsin", "bilmem"})
    @DisplayName("Params Find Test")
    public void paramsTest( String data ) {
        List<Customer> findCustomer = customerRepository.findCustomer(data, data);
        Assertions.assertNotEquals(0, findCustomer.size());
    }

}
