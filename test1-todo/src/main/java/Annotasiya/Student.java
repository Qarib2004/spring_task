package Annotasiya;

import org.springframework.beans.factory.annotation.Autowired;
import spring.core.Address;

public class Student {
    Address address;

    @Autowired
    void setAddress(Address address) {
        this.address = address;
    }
}
