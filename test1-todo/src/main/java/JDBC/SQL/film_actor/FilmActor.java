package JDBC.SQL.film_actor;

import java.time.LocalDateTime;

public class FilmActor {
private int actor_id;
private int film_id;
private LocalDateTime last_update;

    public FilmActor(int actor_id, int film_id, LocalDateTime last_update) {
        this.actor_id = actor_id;
        this.film_id = film_id;
        this.last_update = last_update;
    }

    public FilmActor() {
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getFilm_id(int filmId) {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "actor_id=" + actor_id +
                ", film_id=" + film_id +
                ", last_update=" + last_update +
                '}';
    }
}
