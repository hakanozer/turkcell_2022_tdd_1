package org.example;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuiteTest.class);

        List<Failure> failures = result.getFailures();
        for( Failure item : failures ) {
            System.err.println(item.toString());
        }

        System.out.println( result.getFailureCount() );
        System.out.println(result.wasSuccessful());
    }
}