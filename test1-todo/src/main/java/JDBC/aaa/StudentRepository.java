package JDBC.aaa;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.stereotype.Repository;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.List;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

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

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    public  StudentRepository(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    public void create(){
        String sql  = "CREATE TABLE IF NOT EXISTS public.student (\n" +
                "    id serial PRIMARY KEY,\n" +
                "    name VARCHAR(100) NOT NULL,\n" +
                "    age INT NOT NULL\n" +
                ");";
        this.jdbcTemplate.execute(sql);
    }



    public void insert(Student student){
        try {
            this.jdbcTemplate.update(
                    "insert into student ( name,age) values (?, ?)",
                    student.getName(), student.getAge());
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }

    }


    public void update(Student student) {
        this.jdbcTemplate.update(
                "UPDATE student SET name = ?, age = ? WHERE id = ?",
                student.getName(), student.getAge(), student.getId());
    }


    public void delete(Integer id) {
        this.jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }

    public List<Student> selectAll() {
        return this.jdbcTemplate.query("SELECT id, name, age FROM student", mapper);
    }
    public int count() {
        return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student", Integer.class);
    }

    public List<Student> studentByName(String name) {
        return this.jdbcTemplate.query(
                "SELECT id, name, age FROM student WHERE name = ?",
                new Object[]{name}, mapper);
    }

    public List<Student> studentByAge(Integer age) {
        return this.jdbcTemplate.query(
                "SELECT id, name, age FROM student WHERE age = ?",
                new Object[]{age}, mapper);
    }



    public Student studentById(Integer id){
        Student s = this.jdbcTemplate.queryForObject(
                "select id, name, age from student where id = ?",
                new Object[]{id}, mapper);
        return s;
    }



    RowMapper<Student> mapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setAge(rs.getInt(3));
            return s;
        }
    };
}































//@Repository
//public class StudentRepository {
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
//        return  dataSource;
//    }
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public void create() {
//          String create="CREATE TABLE IF NOT EXISTS student (\n" +
//                "id INT AUTO_INCREMENT PRIMARY KEY, \n" +
//                "name VARCHAR(100) NOT NULL, \n" +
//                "age INT NOT NULL \n" +
//                ")";
//          this.jdbcTemplate.execute(create);
//    }
//    public void insert(Student student){
//        try {
//            this.jdbcTemplate.update(
//                    "INSERT INTO student(id,name,age)  VALUES(1,'test',10);",
//                    student.getName(),student.getAge());
//        }catch (DataIntegrityViolationException e){
//            System.out.println(e.getMessage());
//        }
//    }
//    public void update(Student student) {
//        this.jdbcTemplate.update(
//                "UPDATE student SET name = ?, age = ? WHERE id = ?",
//                student.getName(), student.getAge(), student.getId());
//    }
//    public void delete(Integer id) {
//        this.jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
//    }
//
//    public List<Student> selectAll() {
//        return this.jdbcTemplate.query("SELECT id, name, age FROM student", mapper);
//    }
//    public int count() {
//        return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student", Integer.class);
//    }
//
//    public List<Student> studentByName(String name) {
//        return this.jdbcTemplate.query(
//                "SELECT id, name, age FROM student WHERE name = ?",
//                new Object[]{name}, mapper);
//    }
//
//    public List<Student> studentByAge(Integer age) {
//        return this.jdbcTemplate.query(
//                "SELECT id, name, age FROM student WHERE age = ?",
//                new Object[]{age}, mapper);
//    }
//
//    public Student studentById(Integer id){
//        Student s = jdbcTemplate.queryForObject(
//                "SELECT id,name,age FROM student where id = ?",
//                new Object[]{id},mapper
//        );
//        return s;
//    }
//    RowMapper<Student> mapper = new RowMapper<Student>() {
//        @Override
//        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//         Student s  = new Student();
//         s.setId(rs.getInt(1));
//         s.setName(rs.getString(2));
//         s.setAge(rs.getInt(3));
//         return s;
//        }
//    };
//}
