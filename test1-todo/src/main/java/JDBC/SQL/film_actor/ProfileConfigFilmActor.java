package JDBC.SQL.film_actor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;

@Configuration
public class ProfileConfigFilmActor {

    static{
        try(InputStream configStream = ProfileConfigFilmActor.class.getClassLoader().getResourceAsStream("logging.properties")){
            LogManager.getLogManager().readConfiguration(configStream);
        }catch (IOException e){
            System.out.println("Error loading logging configuration: "+e.getMessage());
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Profile("dev")
    public DataSource dataSourceDev(){
        return creatDataSource("/profiles/application-dev.properties");
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceProd(){
        return creatDataSource("/profiles/application-prod.properties");
    }

    private DataSource creatDataSource(String propertiesFile){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try{Resource resource = new ClassPathResource(propertiesFile);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            dataSource.setUrl(props.getProperty("db.url"));
            dataSource.setUsername(props.getProperty("db.username"));
            dataSource.setPassword(props.getProperty("db.password"));
        }catch (IOException e){
            throw new RuntimeException("Failed to load properties file ",e);
        }
    return  dataSource;
    }
}
