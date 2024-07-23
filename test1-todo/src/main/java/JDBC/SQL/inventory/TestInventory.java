package JDBC.SQL.inventory;

import JDBC.SQL.language.Language;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

public class TestInventory {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod");
        context.register(ProfileConfigInventory.class);
        context.scan("JDBC.SQL.inventory");
        context.refresh();

        InventoryService inventoryService = context.getBean(InventoryService.class);
        List<Inventory> inventories = inventoryService.selectAll();
        for(Inventory inventory:inventories){
            System.out.println(inventories+ " /n");
        }
        context.close();
    }
}
