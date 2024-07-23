package JDBC.SQL.language;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

public class TestLanguage {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod");
        context.register(ProfileConfigLanguage.class);
        context.scan("JDBC.SQL.language");
        context.refresh();
        LanguageService languageService = context.getBean(LanguageService.class);

        List<Language> languages = languageService.selectAll();
        for(Language language:languages){
            System.out.println(language+" /n");
        }
        context.close();
    }
}
