package lifecycle;

public class Student {
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


public void init1(){
        System.out.println(
                "Bean student has been"
                + " instantieded and I'm "
                +"the ini1() method");
    }

    public void destroy1() throws Exception{
        System.out.println(
                "Container has been closed"
                        + " and I'm the destroy() method of student");
    }
}
