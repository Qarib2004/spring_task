package JDBC.SQL.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Category category){
        try{
            this.jdbcTemplate.update(
               "INSERT INTO category SET name(last_update) values(?))",
                    category.getName()
            );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{
            this.jdbcTemplate.update(
              "DELETE FROM category WHERE  category_id=?",id
            );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Category category,int id){
        try{
            this.jdbcTemplate.update(
              "UPDATE category SET name = ? WHERE category_id = ?;",
                    category.getName(),id
            );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }


    public List<Category> selectAll(){
        String sql ="SELECT * FROM category";
        return jdbcTemplate.query(sql,mapper);
    }

    public List<Category> selectById(int id){
        String sql = "SELECT * FROM category WHERE category_id=?";
        return  jdbcTemplate.query(sql,new Object[]{id},mapper);
    }

    RowMapper<Category> mapper = new RowMapper<Category>() {
        @Override
        public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Category category = new Category();
            category.setCategory_id(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
            category.setLast_update(resultSet.getTimestamp(3).toLocalDateTime());
            return category;
        }
    };
}
