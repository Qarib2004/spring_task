package org.todo.test;

import java.util.List;

public interface TodoImp {
    void create(TodoData todo);
    List<TodoData> getAll();
    void update(TodoData todo);
    void delete(int id);
}
