package JDBC.SQL.film_actor;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

@Configuration
public class SpringJdbcConfigFilmActor {
    static {
        try (InputStream configStream = SpringJdbcConfigFilmActor.class.getClassLoader().getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(configStream);
        }catch (IOException e){
            System.out.println("Error loading logging configuration: "+e.getMessage());
        }
    }
}
