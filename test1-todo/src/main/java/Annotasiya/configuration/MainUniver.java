package Annotasiya.configuration;

import Annotasiya.Bean.CollegeConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainUniver {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UniverConfiguration.class);
        Univer univer
                = context.getBean("univerBean", Univer.class);

        // Invoking the method
        // inside main() method
        univer.test();
    }
}
