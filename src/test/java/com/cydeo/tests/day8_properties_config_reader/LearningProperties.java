package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_reading_test() {
        //key = value
        //os.name = Mac OS X
        //user.name = cybertekchicago-1
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"os.version\") = " + System.getProperty("os.version"));
        System.out.println("System.getProperty(\"java.version\") = " + System.getProperty("java.version"));
        //System.getenv().forEach((k, v) -> System.out.println(k + " : " + v));

    }

}