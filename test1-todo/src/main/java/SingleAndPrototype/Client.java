package SingleAndPrototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation/SingleAndPrototype.xml");

        HelloWorld Geeks1 = (HelloWorld)context.getBean("hw");
        Geeks1.setName("Geeks1");
        System.out.println(
                "Hello object (hello1)"
                        + " Your name is: "
                        + Geeks1.getName());

        HelloWorld Geeks2
                = (HelloWorld)context.getBean("hw");

        System.out.println(
                "Hello object (hello2)"
                        + " Your name is: "
                        + Geeks2.getName());

        System.out.println(
                "'Geeks1' and 'Geeks2'"
                        + " are referring"
                        + "to the same object: "
                        + (Geeks1 == Geeks2));

        System.out.println(
                "Address of object Geeks1: "
                        + Geeks1);
        System.out.println(
                "Address of object Geeks2: "
                        + Geeks2);
    }
}
