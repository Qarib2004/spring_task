package JDBC.SQL.actor;

import JDBC.SQL.actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ActorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Actor actor) {
        String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, actor.getFirstName(), actor.getLastName());
    }

    public void delete(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        jdbcTemplate.update(sql, actorId);
    }

    public List<Actor> selectAll() {
        String sql = "SELECT actor_id, first_name, last_name FROM actor";
        return jdbcTemplate.query(sql, new RowMapper<Actor>() {
            @Override
            public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
                Actor actor = new Actor();
                actor.setActorId(rs.getInt("actor_id"));
                actor.setFirstName(rs.getString("first_name"));
                actor.setLastName(rs.getString("last_name"));
                return actor;
            }
        });
    }

    public Actor selectById(int actorId) {
        String sql = "SELECT actor_id, first_name, last_name FROM actor WHERE actor_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{actorId}, new RowMapper<Actor>() {
            @Override
            public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
                Actor actor = new Actor();
                actor.setActorId(rs.getInt("actor_id"));
                actor.setFirstName(rs.getString("first_name"));
                actor.setLastName(rs.getString("last_name"));
                return actor;
            }
        });
    }

    public void update(Actor actor) {
        String sql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
        jdbcTemplate.update(sql, actor.getFirstName(), actor.getLastName(), actor.getActorId());
    }

    // Пример вызова хранимой процедуры
    public void callStoredProcedure(int actorId) {
        String sql = "{call my_stored_procedure(?)}";
        jdbcTemplate.update(sql, actorId);
    }
}
