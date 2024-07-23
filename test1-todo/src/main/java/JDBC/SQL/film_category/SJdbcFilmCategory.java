package JDBC.SQL.film_category;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

@Configuration
public class SJdbcFilmCategory {
    static{
        try(InputStream inputStream = SJdbcFilmCategory.class.getClassLoader().getResourceAsStream("logging.properties")){
            LogManager.getLogManager().readConfiguration(inputStream);
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
