package org.example;

import org.example.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class UserTest {

    @InjectMocks
    UserService userService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginTest() {
       boolean status = userService.login("ali@mail.com","12345");
       Assert.assertEquals(true, status);
    }

    @Test
    public void listTest() {
        List<String> list = userService.list();
        Assert.assertNotEquals(0, list.size());
    }


}
