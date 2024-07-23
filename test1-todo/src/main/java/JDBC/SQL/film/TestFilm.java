package JDBC.SQL.film;

import JDBC.SQL.film_actor.FilmActor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

public class TestFilm {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod");
        context.register(ProfileConfigFilm.class);
        context.scan("JDBC.SQL.film");
        context.refresh();
        FilmService filmService = context.getBean(FilmService.class);

//        List<Film> films = filmService.selectById(1);
//        for (Film film : films) {
//            System.out.println(film);
//        }
//        context.close();
        List<Film> films = filmService.selectAll();
        //System.out.println(films);
        for (Film film : films) {
            System.out.println(film+"/n");
        }
        context.close();
    }
}
