package io.jms.receiver.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.jms.receiver.runnable.ReceiverThreadManager;

public class ReceiverMain {

    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		ReceiverThreadManager manager = (ReceiverThreadManager) context.getBean("receiverThreadManager");
		manager.execute();
    }

}