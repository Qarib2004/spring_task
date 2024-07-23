package SpEL.services;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan()
public class ProfileTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles();
        ctx.register(ProfileTest.class);
        ctx.refresh();
        HelloController controller =  (HelloController)ctx.getBean("helloController");
        controller.sayHello();

    }
}
