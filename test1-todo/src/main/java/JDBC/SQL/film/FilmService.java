package JDBC.SQL.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    private static final Logger logger  = Logger.getLogger(FilmService.class.getName());

    public void insert(Film film){
        logger.info("insert film: "+film);
        filmRepository.insert(film);
    }

    public void delete(int film_id){
        filmRepository.delete(film_id);
    }

    public void update(Film film){
        filmRepository.update(film);
    }

    public List<Film> selectAll(){
        return filmRepository.selectAll();
    }

    public List<Film> selectById(int film_id){
        return filmRepository.selectById(film_id);
    }
}
