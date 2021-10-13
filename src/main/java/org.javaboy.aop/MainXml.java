package org.javaboy.aop;

import org.javaboy.aop.service.MyCalculator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCalculator calculator = (MyCalculator) ctx.getBean("MyCalculatorImpl");
        calculator.add(3,4);
        calculator.min(3,4);
    }
}
