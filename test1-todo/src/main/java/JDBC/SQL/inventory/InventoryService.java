package JDBC.SQL.inventory;

import JDBC.SQL.language.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public InventoryService() {
    }

    private static final Logger logger = Logger.getLogger(InventoryService.class.getName());

    public void insert(Inventory inventory){
        logger.info("Info: "+inventory);
        inventoryRepository.insert(inventory);
    }

    public void delete(int id){
        inventoryRepository.delete(id);
    }

    public void update(Inventory inventory,int id){
        inventoryRepository.update(inventory,id);
    }

    public List<Inventory> selectAll(){
        return inventoryRepository.selectAll();
    }

    public List<Inventory> selectById(int id){
        return inventoryRepository.selectById(id);
    }
}
