package com.works;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
public class ProductDataTest {

    @Autowired
    ProductRepository productRepository;


    @Test
    @Sql(scripts = "classpath:productData.sql")
    public void listTest() {
        List<Product> ls = productRepository.findAll();
        System.out.println(ls);
    }

}
