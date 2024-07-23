package JDBC;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class StudentJDBCTemp {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Student> listStudents(){
        String SQL = "select  * from student";
        List<Student> students = new ArrayList<>();
        //jdbcTemplateObject.query(SQL,new StudentMapper());
        return students;
    }



}
