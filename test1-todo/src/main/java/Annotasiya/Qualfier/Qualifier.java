package Annotasiya.Qualfier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Qualifier {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation/Qualifier.xml");
        Human human = context.getBean("humanObject", Human.class);
        human.startPumping();
    }
}
