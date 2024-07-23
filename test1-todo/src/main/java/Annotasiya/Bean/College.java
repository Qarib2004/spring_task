package Annotasiya.Bean;

import org.springframework.stereotype.Component;

@Component("collegeBean")
public class College {
    private Principal principal;

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    //    public College(Principal principal) {
//        this.principal = principal;
//    }

    public void test(){
        principal.principalInfo();
        System.out.println("Testing college method");
    }
}
