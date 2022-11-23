package org.example;

import org.example.utils.Action;
import org.example.utils.DB;
import org.junit.*;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

import java.sql.Connection;


public class AppTest {

    static Action action = new Action();
    public AppTest() {
        System.out.println("--AppTest--");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass Call");
    }

    Action ac = null;
    @Before
    public void before() {
        ac = new Action();
        System.out.println("before");
    }

    @Test
    public void appTest1() {
        int count = action.count("java");
        System.out.println("appTest1 Call");
        Assert.assertEquals(4, count);
    }

    @Test
    public void appTest2() {
        int count = action.count("java");
        System.out.println("appTest2 Call");
        Assert.assertEquals(5, count);
    }

    @Test
    @Ignore
    public void ignoreTest() {
        System.out.println("ignore");
    }

    @Test
    public void dbTest() throws Exception {
        DB db = new DB();
        Connection con = db.connect();
        Assert.assertNotNull(con);
        Assert.assertEquals(true, !con.isClosed());
    }

    @After
    public void after() {
        System.out.println("after hashcode: " + ac.hashCode());
        ac = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass hashcode: " + action.hashCode());
        action = null;
    }
}
