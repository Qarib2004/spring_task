package JDBC.SQL.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FilmRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Film film){
        String sql = "INSERT INTO film (last_update) VALUES (?)";
        jdbcTemplate.update(sql,film);
    }

    public void delete(int film_id){
        String sql = "DELETE FROM film WHERE film_id = ?";
        jdbcTemplate.update(sql,film_id);
    }

    public List<Film> selectAll(){
        String  sql = "SELECT film_id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, last_update, special_features, fulltext FROM film";
        return jdbcTemplate.query(sql, new RowMapper<Film>() {
            @Override
            public Film mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Film film = new Film();
                film.setFilm_id(resultSet.getInt("film_id"));
                film.setTitle(resultSet.getString("title"));
                film.setDescription(resultSet.getString("description"));
                film.setRelease_year(resultSet.getInt("release_year"));
                film.setLanguage_id(resultSet.getInt("language_id"));
                film.setRental_duration(resultSet.getInt("rental_duration"));
                film.setRental_rate(resultSet.getDouble("rental_rate"));
                film.setLength(resultSet.getInt("length"));
                film.setReplacement_cost(resultSet.getDouble("replacement_cost"));
                film.setRating(resultSet.getString("rating"));
                film.setLast_update(resultSet.getTimestamp("last_update").toLocalDateTime());
                film.setSpecial_features(resultSet.getString("special_features"));
                film.setFulltext(resultSet.getString("fulltext"));
                return film;
            }
        });
    }

    public List<Film> selectById(int film_id){
        String sql = "SELECT film_id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, last_update, special_features, fulltext FROM film WHERE film_id = ?";
        return jdbcTemplate.query(sql,new Object[]{film_id}, new RowMapper<Film>() {
            @Override
            public Film mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Film film = new Film();
                film.setFilm_id(resultSet.getInt("film_id"));
                film.setTitle(resultSet.getString("title"));
                film.setDescription(resultSet.getString("description"));
                film.setRelease_year(resultSet.getInt("release_year"));
                film.setLanguage_id(resultSet.getInt("language_id"));
                film.setRental_duration(resultSet.getInt("rental_duration"));
                film.setRental_rate(resultSet.getDouble("rental_rate"));
                film.setLength(resultSet.getInt("length"));
                film.setReplacement_cost(resultSet.getDouble("replacement_cost"));
                film.setRating(resultSet.getString("rating"));
                film.setLast_update(resultSet.getTimestamp("last_update").toLocalDateTime());
                film.setSpecial_features(resultSet.getString("special_features"));
                film.setFulltext(resultSet.getString("fulltext"));
                return film;
            }
        });
    }

    public void update(Film film) {
        String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, last_update = ?, special_features = ?, fulltext = ? WHERE film_id = ?";
        jdbcTemplate.update(sql, film.getTitle(), film.getDescription(), film.getRelease_year(), film.getLanguage_id(), film.getRental_duration(), film.getRental_rate(), film.getLength(), film.getReplacement_cost(), film.getRating(), film.getLast_update(), film.getSpecial_features(), film.getFulltext(), film.getFilm_id());
    }
}
