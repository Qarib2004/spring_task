package JDBC.SQL.category;

import JDBC.SQL.film_category.FilmCategory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

public class TestCategory {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod");
        context.register(ProfileConfigCategory.class);
        context.scan("JDBC.SQL.category");
        context.refresh();
        CategoryService categoryService = context.getBean(CategoryService.class);

//        Category category = new Category();
//        category.setName("Gamers");
//        categoryService.update(category,10);


        List<Category> films = categoryService.selectById(10);
        //System.out.println(films);
        for (Category film : films) {
            System.out.println(film+"/n");
        }
        context.close();
    }
}
