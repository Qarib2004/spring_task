package Annotasiya;

import org.springframework.stereotype.Component;

@Component(value = "bike")
public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bike started");
    }
}
