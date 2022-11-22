package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    final CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity list() {
        return customerService.list();
    }

    @PostMapping("/add")
    public ResponseEntity add( @RequestBody Customer customer) {
        System.out.println("add Call");
        return customerService.add(customer);
    }

}
