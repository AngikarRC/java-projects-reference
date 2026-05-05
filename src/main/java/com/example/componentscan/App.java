package com.example.componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ComponentScanDemo.xml");

        Employee emp = context.getBean("emp", Employee.class);
        //emp.setSalary(2000000.55);
        System.out.println(emp.toString());

    }
}
