package com.works;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.entities.Customer;
import com.works.props.Currency;
import com.works.props.NewsData;
import com.works.utils.XmlRead;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerRestTest {

    RestTemplate restTemplate;
    ObjectMapper objectMapper;
    XmlRead xmlRead;
    @BeforeAll
    public void beforeAll() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        xmlRead = new XmlRead();
    }

    @Test
    public void customerListTest() {
        String url = "http://localhost:8090/list";
        Customer[] data = restTemplate.getForObject(url, Customer[].class);
        Assertions.assertNotEquals(0, data.length);
    }

    // HttpHeaders
    // HttpEntity
    @Test
    public void customerAddTest() throws JsonProcessingException {
        String url = "http://localhost:8090/add";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //String sendData = "{ \"name\": \"Ahmet\", \"email\": \"ahmet@mail.com\" }";
        Customer customer = new Customer();
        customer.setName("Mehmet Bilki");
        customer.setEmail("mehmet@maili.com");
        String jsonData = objectMapper.writeValueAsString(customer);
        HttpEntity httpEntity = new HttpEntity(jsonData, httpHeaders);

        Customer data = restTemplate.postForObject(url, httpEntity, Customer.class);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(data),
                () -> Assertions.assertNotEquals(0, data.getCid())
        );
    }

    @Test
    public void newsTest() {
        String url = "https://newsapi.org/v2/everything?q=bitcoin&from=2022-10-22&sortBy=publishedAt&apiKey=38a9e086f10b445faabb4461c4aa71f8";
        NewsData newsData = restTemplate.getForObject(url, NewsData.class);
        newsData.getArticles().forEach( item -> {
            System.out.println( item.getTitle() );
        });
        Assertions.assertEquals("ok", newsData.getStatus());
    }

    @Test
    public void xmlTest() {
        List<Currency> currencies = xmlRead.xml();
        Assertions.assertNotEquals(0, currencies.size());
        Assertions.assertNotNull(currencies.get(0).getForexBuying());
    }

}
