package spring.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestStudent {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("annotation/Bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Student student = (Student)factory.getBean("studentObj");
        student.displayInfo();

        Student student1 = (Student)factory.getBean("studentObj1");
        student1.displayInfo();
    }
}
