package todos;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private Integer id;
    private String name;
    private String description;
    private List<TodoRequest> todos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TodoRequest> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoRequest> todos) {
        this.todos = todos;
    }
}
