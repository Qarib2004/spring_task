package JDBC.aaa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//package org.servlet.core.spring.jdbc.aaa;

//import org.servlet.core.spring.jdbc.StudentJDBCTemp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

@Configuration
//@ComponentScan("org.servlet.core.spring.jdbc.aaa")
public class SpringJdbcConfig {

    static {
        // Load logging configuration from logging.properties
        try (InputStream configStream = SpringJdbcConfig.class.getClassLoader().getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(configStream);
        } catch (IOException e) {
            System.err.println("Error loading logging configuration: " + e.getMessage());
        }
    }


//    @Bean
//    public DataSource dataSource()
//    {
//        DriverManagerDataSource dataSource
//                = new DriverManagerDataSource();
////        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl( "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
//        return dataSource;
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }

//    @Bean
//    public DataSource dataSourcePg()
//    {
//        DriverManagerDataSource dataSource
//                = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl( "jdbc:postgresql://localhost:54321/dvdrental");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres");
//        return dataSource;
//    }
//    @Bean
//    public StudentJDBCTemp studentJDBCTemp() {
//        StudentJDBCTemp studentJDBCTemp = new StudentJDBCTemp();
//        studentJDBCTemp.setDataSource(dataSource());
//        return studentJDBCTemp;
//    }

//    @Bean
//    public StudentJDBCTemp postgresqlTemplate() {
//        StudentJDBCTemp studentJDBCTemp = new StudentJDBCTemp();
//        studentJDBCTemp.setDataSource(dataSourcePg());
//        return studentJDBCTemp;
//    }
}