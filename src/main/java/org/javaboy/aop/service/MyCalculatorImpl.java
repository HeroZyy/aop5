package org.javaboy.aop.service;

import org.javaboy.aop.Action;
import org.springframework.stereotype.Component;

@Component
public class MyCalculatorImpl implements MyCalculator{
    @Action
    public Integer add(int a, int b) {
        System.out.println((a + "+" + b + "=" + (a + b)));
//        int c = 1/0;
        return (a + b);
    }

    @Action
    public void min(int a, int b) {
        System.out.println((a + "-" + b + "=" + (a - b)));
    }
}
