package com.mashibing.test;

import com.mashibing.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = (Person)app.getBean("person");
        System.out.println(person);
    }

    public void method(String a,String b){

    }

    private String method(String a,String b,String c){
        return a+b+c;
    }
}
