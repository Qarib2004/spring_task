package SpEL.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("SpEL/application.properties")
public class HelloServiceEnglishImp implements HelloService{


    @Value("#{new SpEL.services.TestEl().name} + ' ${greeting}'")
    //@Value("${greeting}")
    //@Value("${number}")

    private String greeting;
    private double number;

    @Override
    public String getGreeting() {
        return String.valueOf(greeting);
    }
}
