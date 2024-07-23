package JDBC.SQL.film_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FilmCategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(FilmCategory filmCategory){
        try{this.jdbcTemplate.update(
          "INSERT INTO film_category () values(?);",
                filmCategory.getCategory_id(),filmCategory.getLast_update()
        );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public  void delete(int fcId){
        try{
            this.jdbcTemplate.update("DELETE FROM film_category WHERE category_id=?",fcId
            );
        }catch (DataIntegrityViolationException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void update(FilmCategory filmCategory,int id){
        try{
            this.jdbcTemplate.update(
              "UPDATE film_category SET category_id,last_update WHERE id=?",
                    filmCategory.getCategory_id(),filmCategory.getLast_update(),id
            );
        }catch (DataIntegrityViolationException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public List<FilmCategory> selectAll(){
        String sql = "SELECT * FROM film_category;";
        return jdbcTemplate.query(sql,mapper);
    }

    public List<FilmCategory> selectById(int id){
        String sql = "SELECT * FROM film_category WHERE category_id=?";
        return  jdbcTemplate.query(sql,new Object[]{id},mapper);
    }

    RowMapper<FilmCategory> mapper = new RowMapper<FilmCategory>() {
        @Override
        public FilmCategory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            FilmCategory filmCategory = new FilmCategory();
            filmCategory.setFilm_id(resultSet.getInt(1));
            filmCategory.setCategory_id(resultSet.getInt(2));
            filmCategory.setLast_update(resultSet.getTimestamp(3).toLocalDateTime());
            return filmCategory;
        }
    };
}
