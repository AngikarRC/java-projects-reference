package com.ioc.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCExample {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationiocLooseCoupling.xml");

        UserManager sql = (UserManager) context.getBean("UserManagerWithMySQL");
        System.out.println(sql.getUserinfo());
        UserManager nosql = (UserManager) context.getBean("UserManagerWithNoSQL");
        System.out.println(nosql.getUserinfo());
        UserManager web = (UserManager) context.getBean("UserManagerWithMyWeb");
        System.out.println(web.getUserinfo());
    }

}
