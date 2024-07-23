package JDBC.aaa;

import JDBC.aaa.Student;
import JDBC.aaa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentService {


    @Autowired
    StudentRepository repository;


    private static final Logger logger = Logger.getLogger(StudentService.class.getName());

    public void create(){
        repository.create();
    }
    public void insert(Student student){
        logger.info("insert student : " + student);
        repository.insert(student);
    }

    public Student studentById(Integer id){
        return repository.studentById(id);
    }

    public List<Student> getAllStudents() {
        return repository.selectAll();
    }

    public Student getStudentById(int id) {
        return repository.studentById(id);
    }

    public void addStudent(Student student) {
        repository.insert(student);
    }

    public void updateStudent(Student student) {
        repository.update(student);
    }

    public void deleteStudent(int id) {
        repository.delete(id);
    }

    public List<Student> getStudentsByName(String name) {
        return repository.studentByName(name);
    }

    public List<Student> getStudentsByAge(int age) {
        return repository.studentByAge(age);
    }

    public int countStudents() {
        return repository.count();
    }
}



//package JDBC.aaa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    public List<Student> getAllStudents() {
//        return studentRepository.selectAll();
//    }
//
//    public Student getStudentById(int id) {
//        return studentRepository.studentById(id);
//    }
//
//    public void addStudent(Student student) {
//        studentRepository.insert(student);
//    }
//
//    public void updateStudent(Student student) {
//        studentRepository.update(student);
//    }
//
//    public void deleteStudent(int id) {
//        studentRepository.delete(id);
//    }
//
//    public List<Student> getStudentsByName(String name) {
//        return studentRepository.studentByName(name);
//    }
//
//    public List<Student> getStudentsByAge(int age) {
//        return studentRepository.studentByAge(age);
//    }
//
//    public int countStudents() {
//        return studentRepository.count();
//    }
//}
