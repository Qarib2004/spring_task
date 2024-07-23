package Autowiring;

import org.springframework.beans.factory.annotation.Autowired;

public class City {
    private int id;
    private String name;
    private State s;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getS() {
        return s;
    }

    @Autowired public void setState(State st) {
        this.s = st;
    }

    void showCity(){
        System.out.println("ID: "+id +" "
                           +"Name: "+name+" "
                           +"State: "+s);
    }
}
