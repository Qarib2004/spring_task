package JDBC.SQL.inventory;

import java.time.LocalDateTime;

public class Inventory {
    private int inventory_id;
    private int film_id;
    private int store_id;
    private LocalDateTime last_update;

    public Inventory(int inventory_id, int film_id, int store_id, LocalDateTime last_update) {
        this.inventory_id = inventory_id;
        this.film_id = film_id;
        this.store_id = store_id;
        this.last_update = last_update;
    }

    public Inventory() {
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", film_id=" + film_id +
                ", store_id=" + store_id +
                ", last_update=" + last_update +
                '}';
    }
}
