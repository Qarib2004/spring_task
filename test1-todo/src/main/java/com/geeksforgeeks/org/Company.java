package com.geeksforgeeks.org;

import java.util.Map;

public class Company {
    private Map<String,String> employees;

    public Company(Map<String, String> employees) {
        this.employees = employees;
    }

    public void display(){
        for(Map.Entry<String,String> entry: employees.entrySet()){
            System.out.println(
                    "Employee Id ->" + entry.getKey() + ","
                            + " Department->" + entry.getValue());
        }
    }
}
