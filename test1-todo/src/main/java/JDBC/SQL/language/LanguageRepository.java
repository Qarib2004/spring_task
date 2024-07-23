package JDBC.SQL.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LanguageRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Language language){
        try {this.jdbcTemplate.update(
                "INSERT INTO language SET name(last_update) VALUES(?);",language.getName()
        );

        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Language language,int id){
        try{this.jdbcTemplate.update(
          "UPDATE language SET name = ? WHERE language_id = ?",
          language.getName(),id
        );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{this.jdbcTemplate.update(
             "DELETE FROM language WHERE language_id = ?", id
        );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Language> selectAll(){
        String sql = "SELECT * FROM language;";
        return jdbcTemplate.query(sql,mapper);
    }


    public List<Language> selectByID(int id){
        String sql = "SELECT  FROM language WHERE language_id=?;";
        return jdbcTemplate.query(sql,new Object[]{id},mapper);
    }


    RowMapper<Language> mapper = new RowMapper<Language>() {
        @Override
        public Language mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Language language = new Language();
            language.setLanguage_id(resultSet.getInt(1));
            language.setName(resultSet.getString(2));
            language.setLast_update(resultSet.getTimestamp(3).toLocalDateTime());
            return language;
        }
    };
}
