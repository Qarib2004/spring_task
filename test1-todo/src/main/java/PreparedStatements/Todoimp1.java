package PreparedStatements;

import org.todo.test.TodoData;

import java.util.List;

public interface Todoimp1 {
    void create(TodoData todo);
    List<TodoData> getAll();
    void update(TodoData todo);
    void delete(int id,TodoData todo);
}
