package JDBC.SQL.film_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FilmCategoryService {
    @Autowired
    FilmCategoryRepository filmCategoryRepository;

    public FilmCategoryService(FilmCategoryRepository filmCategoryRepository) {
        this.filmCategoryRepository = filmCategoryRepository;
    }
    public FilmCategoryService() {
    }

    public static  final Logger logger = Logger.getLogger(FilmCategoryService.class.getName());

    public void insert(FilmCategory filmCategory){
        logger.info("Info: "+filmCategory);
        filmCategoryRepository.insert(filmCategory);
    }

    public void delete(int id){
        filmCategoryRepository.delete(id);
    }


    public void update(FilmCategory filmCategory,int id){
        filmCategoryRepository.update(filmCategory,id);
    }

    public List<FilmCategory> selectAll(){
        return filmCategoryRepository.selectAll();
    }

    public List<FilmCategory> selectById(int id){
        return filmCategoryRepository.selectById(id);
    }
}
