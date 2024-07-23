package SpEL.spel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration
@ComponentScan
public class SpelTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles();
        context.register(SpEL.spel.SpelTest.class);
        context.refresh();
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpEL/spel.xml");
        InjectSpel injectSpel = (InjectSpel) context.getBean("injectSpel");
        System.out.println(injectSpel);
    }
}
