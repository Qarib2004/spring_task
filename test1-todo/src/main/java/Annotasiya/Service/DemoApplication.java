package Annotasiya.Service;

import Annotasiya.Service.MyServiceClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext appCon = new AnnotationConfigApplicationContext();
//        appCon.scan("Annotasiya.Service");
//        appCon.refresh();
//
//        MyServiceClass myServiceClass = appCon.getBean(MyServiceClass.class);
//
//        int factorialOf5 = myServiceClass.factorial(5);
//        System.out.println("Factorial of 5 is: "+factorialOf5);
//        appCon.close();
        ApplicationContext appCon = SpringApplication.run(DemoApplication.class, args);

        MyServiceClass myServiceClass = appCon.getBean(MyServiceClass.class);

        int factorialOf5 = myServiceClass.factorial(5);
        System.out.println("Factorial of 5 is: " + factorialOf5);
    }
}
