package JDBC.SQL.category;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

@Configuration
public class SpringJdbcCategory {
    static{
        try( InputStream inputStream = SpringJdbcCategory.class.getClassLoader().getResourceAsStream("logging.properties")){
            LogManager.getLogManager().readConfiguration(inputStream);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
