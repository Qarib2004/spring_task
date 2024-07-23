package Annotasiya.value;

import org.springframework.beans.factory.annotation.Value;

public class Student {
    private int rollNo;
    private String name;
    private int age;

    @Value("40") public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    @Value("Qarib") public void setName(String name) {
        this.name = name;
    }

    @Value("20") public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
