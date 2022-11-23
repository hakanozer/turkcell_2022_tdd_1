package org.example;

import org.example.services.FileService;
import org.example.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.runner.OrderWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserTest {

    @InjectMocks
    UserService userService;

    @InjectMocks
    FileService fileService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginTest() {
       boolean status = userService.login("ali@mail.com","' or 1 = 1 --");
       Assert.assertEquals(true, status);
    }

    @Test
    public void listTest() {
        List<String> list = userService.list();
        Assert.assertNotEquals(0, list.size());
    }

    @Test(timeout = 1500)
    public void restTest() {
        long start = System.currentTimeMillis();
        boolean status = userService.restUserLogin("zehra@mail.com", "12345");
        long end = System.currentTimeMillis();
        long between = end - start;
        System.out.println("between : " + between);
        Assert.assertEquals(true, status);
    }


    @Order(1)
    @Test
    public void aCreateFileTest() {
        boolean statusCreate = fileService.createFile();
        Assert.assertEquals(true, statusCreate);
        boolean status = fileService.fileControl();
        Assert.assertEquals(true, status);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void windows() {
        Assert.assertTrue(true);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    public void mac() {
        Assert.assertTrue(true);
    }

    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9})
    @Test
    public void jre() {
        System.out.println("JRE JAVA_8");
    }


}
