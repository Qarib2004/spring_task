package JDBC.SQL.language;

import java.time.LocalDateTime;

public class Language {
    private int  language_id;
    private String name;
    private LocalDateTime last_update;

    public Language(int language_id, String name, LocalDateTime last_update) {
        this.language_id = language_id;
        this.name = name;
        this.last_update = last_update;
    }

    public Language() {
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Language{" +
                "language_id=" + language_id +
                ", name='" + name + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
