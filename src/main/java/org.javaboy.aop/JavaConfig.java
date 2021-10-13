package org.javaboy.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
//开启自动代理
@EnableAspectJAutoProxy
public class JavaConfig {
}
