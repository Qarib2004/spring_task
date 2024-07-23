package lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentAppContext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation/LifeCycleBean.xml");
        Student student = context.getBean("studentObj11", Student.class);
        student.displayInfo();

        HelloWorld hl = context.getBean("hw", HelloWorld.class);

        context.close();
    }
}
