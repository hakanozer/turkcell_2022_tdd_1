package com.works;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    String appUuid;

    @Test
    public void addTest() {
        Customer customer = new Customer();
        customer.setName("Asya Bil");
        customer.setEmail("asya@mail.com");

        ResponseEntity<Customer> customerResponseEntity = customerService.add(customer);
        customer = customerResponseEntity.getBody();
        //System.out.println(customer);
        //System.out.println(customerResponseEntity.getStatusCodeValue());

        System.out.println(appUuid);
        final Customer finalCustomer = customer;
        Assertions.assertAll(
                () -> Assertions.assertNotNull(finalCustomer),
                () -> Assertions.assertEquals(200, customerResponseEntity.getStatusCodeValue())
        );
    }

    @Test
    @Disabled
    public void callTest() {
        System.out.println("callTest Call");
        int i = 0;
        Assertions.assertEquals(1, i);
    }

}
