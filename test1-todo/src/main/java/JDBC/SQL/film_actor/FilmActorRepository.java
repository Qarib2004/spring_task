package JDBC.SQL.film_actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FilmActorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(FilmActor filmActor) {
        String sql = "INSERT INTO afilm_actor (last_update) VALUES (?)";
        jdbcTemplate.update(sql,filmActor.getLast_update());
    }

    public void delete(int film_id){
        String sql = "DELETE FROM film_actor WHERE film_id = ?";
        jdbcTemplate.update(sql,film_id);
    }


    public List<FilmActor> selectAll(){
        String sql = "SELECT actor_id,film_id,last_update FROM actor";
        return jdbcTemplate.query(sql, new RowMapper<FilmActor>() {
            @Override
            public FilmActor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                FilmActor filmActor = new FilmActor();
                filmActor.setActor_id(resultSet.getInt("actor_id"));
                filmActor.setFilm_id(resultSet.getInt("film_id"));
                filmActor.setLast_update(resultSet.getTimestamp("last_update").toLocalDateTime());
                return filmActor;
            }
        });
    }


public List<FilmActor> selectById(int film_id) {
    String sql = "SELECT actor_id, film_id, last_update FROM film_actor WHERE film_id = ?";
    return jdbcTemplate.query(sql, new Object[]{film_id}, new RowMapper<FilmActor>(){
        @Override
        public FilmActor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            FilmActor filmActor = new FilmActor();
            filmActor.setActor_id(resultSet.getInt("actor_id"));
            filmActor.setFilm_id(resultSet.getInt("film_id"));
            filmActor.setLast_update(resultSet.getTimestamp("last_update").toLocalDateTime());
            return filmActor;
        }
    });
}

    public void update(FilmActor filmActor){
        String sql = "UPDATE film_actor SET last_update = ? WHERE id = ?";
        jdbcTemplate.update(sql,filmActor.getActor_id(),filmActor.getLast_update());
    }
}
