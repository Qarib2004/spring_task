package JDBC.SQL.film_category;

import java.time.LocalDateTime;

public class FilmCategory {
    private int film_id;
    private int category_id;
    private LocalDateTime last_update;

    public FilmCategory(int film_id, int category_id, LocalDateTime last_update) {
        this.film_id = film_id;
        this.category_id = category_id;
        this.last_update = last_update;
    }

    public FilmCategory() {
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "film_id=" + film_id +
                ", category_id=" + category_id +
                ", last_update=" + last_update +
                '}';
    }
}
