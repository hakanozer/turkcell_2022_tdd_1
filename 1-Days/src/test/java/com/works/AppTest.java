package com.works;

import com.works.utils.Action;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {

    Action action = null;
    @BeforeAll
    public void beforeAll() {
        System.out.println("beforeAll");
        action = new Action();
    }

    @BeforeEach
    public void beforeEach() {
        long start = System.currentTimeMillis();
        System.out.println("beforeEach :" + start);
    }

    @Test
    public void oneTest() {
        int sm = action.sum(50, 60);
        Assertions.assertEquals(100, sm);
    }

    @Test
    public void twoTest() {
        Assertions.assertEquals(true, true);
    }

    @AfterEach
    public void afterEach() {
        long end = System.currentTimeMillis();
        System.out.println("afterEach :" + end);
    }

    @AfterAll
    public void afterAll() {
        System.out.println("afterAll");
        action = null;
    }

}
