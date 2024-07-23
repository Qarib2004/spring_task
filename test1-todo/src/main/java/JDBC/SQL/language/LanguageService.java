package JDBC.SQL.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public LanguageService() {
    }

    private static final Logger logger = Logger.getLogger(LanguageService.class.getName());

    public void insert(Language language){
        logger.info("Info: "+language);
        languageRepository.insert(language);
    }

    public void delete(int id){
        languageRepository.delete(id);
    }

    public void update(Language language,int id){
        languageRepository.update(language,id);
    }

    public List<Language> selectAll(){
        return languageRepository.selectAll();
    }

    public List<Language> selectById(int id){
        return languageRepository.selectByID(id);
    }
}
