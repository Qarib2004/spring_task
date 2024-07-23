package Annotasiya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {
    @Autowired
    @Qualifier("bike")
    private Vehicle vehicle;
    public void service(){
        vehicle.start();;
    }
}
