package com.works.repositories;

import com.works.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByEmailEqualsIgnoreCase(String email);

    @Query("select c from Customer c " +
            "where upper(c.name) like upper(concat('%', ?1, '%')) or upper(c.email) like upper(concat('%', ?2, '%'))")
    List<Customer> findCustomer(String name, String email);





}