package JDBC.SQL.actor;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
@Configuration
public class SpringJdbcConfigActor {

        static {
            // Load logging configuration from logging.properties
            try (InputStream configStream = SpringJdbcConfigActor.class.getClassLoader().getResourceAsStream("logging.properties")) {

                LogManager.getLogManager().readConfiguration(configStream);
            } catch (IOException e) {
                System.err.println("Error loading logging configuration: " + e.getMessage());
            }
        }
}
