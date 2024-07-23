package Annotasiya;

import org.springframework.stereotype.Component;

@Component(value = "car")
public class Car implements Vehicle{

    @Override
    public void start() {
        System.out.println("Car started");
    }
}
