package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> list() {
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }


    public ResponseEntity add( Customer customer ) {
        customerRepository.save(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }

}
