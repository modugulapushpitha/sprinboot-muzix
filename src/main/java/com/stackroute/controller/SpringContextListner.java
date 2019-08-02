package com.stackroute.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class SpringContextListner {
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Started with Application listner");
    };

}
