package com.works;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.entities.Customer;
import com.works.restcontrollers.CustomerRestController;
import com.works.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {CustomerRestController.class})
public class CustomerRestMockTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CustomerService customerService;

    @Test
    public void addMockTest() throws Exception {

        Customer customer = new Customer();
        customer.setEmail("kaan@mail.com");
        customer.setName("Kaan Bilsin");
        String stCustomer = objectMapper.writeValueAsString(customer);

       mockMvc.perform(
               MockMvcRequestBuilders.post("/add")
               .contentType(MediaType.APPLICATION_JSON)
               .header("JWT", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
               .content(stCustomer))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void listMockTest() throws Exception {

        MvcResult mvcResult =  mockMvc.perform(
                MockMvcRequestBuilders.get("/list")
        ).andReturn();

       int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);

    }

}
