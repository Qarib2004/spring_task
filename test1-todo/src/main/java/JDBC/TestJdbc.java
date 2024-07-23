package JDBC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestJdbc {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        StudentJDBCTemp studentJDBCTemp = context.getBean(StudentJDBCTemp.class);
        List<Student> students = studentJDBCTemp.listStudents();
        for(Student student:students){
            System.out.println("ID: "+student.getId() + " Name: "+student.getName());
        }
        context.close();
    }
}
