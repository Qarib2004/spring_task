package JDBC;

//import org.h2.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("JDBC")
public class SpringJdbcConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("dbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
    @Bean
    public StudentJDBCTemp studentJDBCTemp(){
        StudentJDBCTemp studentJDBCTemp = new StudentJDBCTemp();
        studentJDBCTemp.setDataSource(dataSource());
        return studentJDBCTemp;
    }
}
