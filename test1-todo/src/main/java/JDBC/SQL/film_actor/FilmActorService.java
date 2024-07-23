package JDBC.SQL.film_actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FilmActorService {
    public FilmActorService(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }

    private static final Logger logger = Logger.getLogger(FilmActorService.class.getName());

    @Autowired
    FilmActorRepository filmActorRepository;

    public void insert(FilmActor filmActor){
        logger.info("insert film_actor: " + filmActor);
        filmActorRepository.insert(filmActor);
    }

    public void delete(int filmId){
        filmActorRepository.delete(filmId);
    }

    public List<FilmActor> selectAll(){
        return filmActorRepository.selectAll();
    }

    public List<FilmActor> selectById(int filmId){
        return (List<FilmActor>) filmActorRepository.selectById(filmId);
    }

    public void update(FilmActor filmActor){
        filmActorRepository.update(filmActor);
    }
}
