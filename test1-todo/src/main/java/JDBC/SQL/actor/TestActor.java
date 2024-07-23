package JDBC.SQL.actor;

import JDBC.SQL.actor.Actor;
import JDBC.SQL.actor.ActorService;
import JDBC.SQL.actor.ProfileConfigActor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestActor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod");
        context.register(ProfileConfigActor.class);
        context.scan("JDBC.SQL.actor");


        context.refresh();

        ActorService actorService = context.getBean(ActorService.class);

        // Пример вставки
//        Actor actor = new Actor();
//        actor.setFirstName("Tom");
//        actor.setLastName("Hanks");
//        actorService.insert(actor);

        // Пример выбора по ID
        Actor selectedActor = actorService.selectById(17);
        System.out.println(selectedActor);

        // Пример обновления
//        selectedActor.setLastName("Updated LastName");
//        actorService.update(selectedActor);
//
//        // Пример удаления
//        actorService.delete(1);
//
//        // Пример вызова хранимой процедуры
//        actorService.callStoredProcedure(1);
    }
}

