package JDBC.SQL.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InventoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Inventory inventory){
        try{this.jdbcTemplate.update(
          "INSERT INTO inventory SET "
        );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{this.jdbcTemplate.update(
          "DELETE FROM inventory WHERE inventory_id=?;",id
        );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Inventory inventory,int id){
        try{this.jdbcTemplate.update(
          "UPDATE inventory  SET inventory id = ? WHERE inventory_id=?;",
                inventory.getInventory_id(),id
        );
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Inventory> selectAll(){
        String sql = "SELECT * FROM inventory;";
        return jdbcTemplate.query(sql,mapper);
    }

    public List<Inventory>  selectById(int id){
        String sql = "SELECT * FROM inventory WHERE inventory_id=?";
        return jdbcTemplate.query(sql,new Object[]{id},mapper);
    }


    RowMapper<Inventory> mapper = new RowMapper<Inventory>() {
        @Override
        public Inventory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Inventory inventory = new Inventory();
            inventory.setInventory_id(resultSet.getInt(1));
            inventory.setFilm_id(resultSet.getInt(2));
            inventory.setStore_id(resultSet.getInt(3));
            inventory.setLast_update(resultSet.getTimestamp(4).toLocalDateTime());
            return inventory;
        }
    };
}
