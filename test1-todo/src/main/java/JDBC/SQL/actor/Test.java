package JDBC.SQL.actor;

import JDBC.aaa.Student;
import JDBC.aaa.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.scan("JDBC.aaa");
        context.refresh();

//        ActorService service = context.getBean(ActorService.class);
//        service.create();


//        Actor selectedActor = actorService.selectById(1);
//        System.out.println(selectedActor);

    }
}
