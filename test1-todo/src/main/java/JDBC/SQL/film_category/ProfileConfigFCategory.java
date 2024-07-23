package JDBC.SQL.film_category;

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
public class ProfileConfigFCategory {
    static{
        try (InputStream inputStream = SJdbcFilmCategory.class.getClassLoader().getResourceAsStream("logging.properties")){
            LogManager.getLogManager().readConfiguration(inputStream);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private DataSource dataSource(String propertiesFile){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try{
            Resource resource = new ClassPathResource(propertiesFile);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            dataSource.setUrl(props.getProperty("db.url"));
            dataSource.setUsername(props.getProperty("db.username"));
            dataSource.setPassword(props.getProperty("db.password"));
        }catch (IOException e){
            throw new RuntimeException("Failed to load properties file ",e);
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Profile("dev")
    public DataSource  dataSourceDev(){
        return  dataSource("/profiles/application-dev.properties");
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceProd(){
        return  dataSource("/profiles/application-prod.properties");
    }
}
