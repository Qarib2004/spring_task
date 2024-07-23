package Annotasiya.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UniverConfiguration {
   @Bean
   public Univer univerBean(){
        return new Univer();
    }
}
