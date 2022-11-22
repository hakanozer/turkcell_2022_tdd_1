package com.works;

import com.works.utils.Action;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.TestPropertySource;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource("classpath:application.properties")
@SpringBootTest
public class ActionTest {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    Action action;
    DriverManagerDataSource dataSource;
    @BeforeAll
    public void beforeAll() {
        action = new Action();
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    @Order(0)
    @Test
    public void dbConnectTest() throws Exception {
        try {
            boolean isConnect =  dataSource.getConnection().isClosed();
            Assertions.assertEquals(true, !isConnect);
        }catch (Exception ex) {
            throw new Exception("");
        }

    }

    public int i = 1;
    @Order(1)
    @ParameterizedTest
    @CsvSource(value = {"10,20", "44,55", "66,88"})
    public void paramsMultiTest( int num1, int num2 ) {
        System.out.println(num1 + "," + num2 );
        int sm = action.sum(num1, num2);
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(0, sm),
                () -> Assertions.assertNotNull(action)
        );
        int end = 0;
        if (i == 1)
            end = 30;
        if (i == 2)
            end = 99;
        if (i == 3)
            end = 154;
        Assertions.assertEquals(end, sm);
        i++;
    }

    @Order(2)
    @Test
    public void iTest() {
        System.out.println("i:" + i);
    }

    @Order(3)
    @ParameterizedTest
    @CsvSource(value = {"Ali, Bilmem", "Veli, Bilirim"})
    public void paramsMultiString( String name, String surname ) {
        System.out.println(name + " " + surname);
    }

    @Test
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testTimed() {
        try {
            Thread.sleep(500);
            //Assertions.assertEquals(true, true);
        }catch (Exception ex) { }
        //System.out.println("testTimed Call");
    }

    int x = 0;
    @RepeatedTest(value = 5)
    public void repeatTest() {
        System.out.println("repeatTest Call :" + x);
        x++;
    }


}
