package JDBC.SQL.film_actor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

public class TestFilmActor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod");
        context.register(ProfileConfigFilmActor.class);
        context.scan("JDBC.SQL.actor.film_actor");
        context.refresh();


        FilmActorService filmActorService = context.getBean(FilmActorService.class);
       // List<FilmActor> filmActor = filmActorService.selectById(1);
        List<FilmActor> filmActors = filmActorService.selectById(1);
        for (FilmActor filmActor : filmActors) {
            System.out.println(filmActor);
        }
        context.close();
    }
}
