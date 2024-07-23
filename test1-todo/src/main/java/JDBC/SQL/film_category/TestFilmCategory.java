package JDBC.SQL.film_category;

import JDBC.SQL.film.Film;
import JDBC.SQL.film.FilmService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

public class TestFilmCategory {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod");
        context.register(ProfileConfigFCategory.class);
        context.scan("JDBC.SQL.film_category");
        context.refresh();
        FilmCategoryService filmCategoryService = context.getBean(FilmCategoryService.class);

        List<FilmCategory> films = filmCategoryService.selectById(10);
        //System.out.println(films);
        for (FilmCategory film : films) {
            System.out.println(film+"/n");
        }
        context.close();
    }
}
