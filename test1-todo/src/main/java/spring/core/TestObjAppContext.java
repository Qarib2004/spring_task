package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestObjAppContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation/Bean.xml");
        Employee emp = context.getBean("o", Employee.class);
        emp.show();
    }
}
