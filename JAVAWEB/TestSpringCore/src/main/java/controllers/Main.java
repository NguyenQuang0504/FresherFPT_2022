package controllers;

import model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

//        User user = (User) applicationContext.getBean("User1");
//        System.out.println(user.toString());

        Customer customer = (Customer) applicationContext.getBean("Customer");
        System.out.println(customer.getAddress().toString());

        Customer customer1 = (Customer) applicationContext.getBean("Customer1");
        System.out.println(customer1.getAddress().getName());

    }
}
