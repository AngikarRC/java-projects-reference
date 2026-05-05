package com.example.autowired.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("ComponentScanDemo.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp = context.getBean("emp", Employee.class);
        //emp.setSalary(2000000.55);

        Manager manager = context.getBean("manager",Manager.class);
        System.out.println(emp.toString());
        System.out.println(manager.toString());

    }
}
