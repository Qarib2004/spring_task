package JDBC.SQL.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ActorService {



    private static final Logger logger = Logger.getLogger(ActorService.class.getName());

    @Autowired
    private ActorRepository repository;


//    public void create(){
//        repository.create();
//    }

    public void insert(Actor actor) {
        logger.info("insert student : " + actor);
        repository.insert(actor);
    }

    public void delete(int actorId) {
        repository.delete(actorId);
    }

    public List<Actor> selectAll() {
        return repository.selectAll();
    }

    public Actor selectById(int actorId) {
        return repository.selectById(actorId);
    }

    public void update(Actor actor) {
        repository.update(actor);
    }

    public void callStoredProcedure(int actorId) {
        repository.callStoredProcedure(actorId);
    }
}
