package Autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 class DemoApplication {
    public static void main(String[] args) {

                ApplicationContext context = new ClassPathXmlApplicationContext("annotation/Autowiring.xml");

                City cty = context.getBean("city", City.class);
                cty.setId(01);
                cty.setName("Varanasi");
                State st = context.getBean("state", State.class);
                st.setName("UP");
                cty.setState(st);
                cty.showCity();
            }
}
