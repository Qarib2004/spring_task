package Annotasiya.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation/value.xml");
        Student student = context.getBean("student", Student.class);
        student.display();
    }
}
