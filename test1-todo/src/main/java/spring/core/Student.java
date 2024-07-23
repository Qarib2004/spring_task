package spring.core;

// Java Program where we are
// creating a POJO class

// POJO class
public class Student {

    // Member variables
    private String name;

    // Constructor 1
    public Student() {
    }

    // Constructor 2
    public Student(String name) {
        this.name = name;
    }

    // Method inside POJO class
    @Override
    public String toString() {

        // Print student class attributes
        return "Student{" + "name='" + name + '\'' + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void displayInfo(){
        System.out.println("Name: "+name);
    }
}
