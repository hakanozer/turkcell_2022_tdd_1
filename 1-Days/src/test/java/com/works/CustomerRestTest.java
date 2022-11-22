package com.works;

import com.works.entities.Customer;
import com.works.props.NewsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerRestTest {

    RestTemplate restTemplate;
    @BeforeAll
    public void beforeAll() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void customerListTest() {
        String url = "http://localhost:8090/list";
        Customer[] data = restTemplate.getForObject(url, Customer[].class);
        Assertions.assertNotEquals(0, data.length);
    }

    @Test
    public void customerAddTest() {
        String url = "http://localhost:8090/add";
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

}
