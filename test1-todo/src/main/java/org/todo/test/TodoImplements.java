package org.todo.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoImplements implements TodoImp {
    @Override
    public void create(TodoData todo) {
        String sql = String.format("INSERT INTO todos (title, description, status, due_date) VALUES ('%s', '%s', '%s', '%s')",
                todo.getTitle(), todo.getDescription(), todo.getStatus(), todo.getDueDate());

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("ToDo created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating ToDo: " + e.getMessage());
        }
    }

    @Override
    public List<TodoData> getAll() {
        List<TodoData> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TodoData todo = new TodoData(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getDate("due_date").toLocalDate()
                );
                todos.add(todo);
            }
        } catch (SQLException e) {
            System.out.println("Error getting ToDos: " + e.getMessage());
        }

        return todos;
    }

    @Override
    public void update(TodoData todo) {
        String sql = String.format("UPDATE todos SET title = '%s', description = '%s', status = '%s', due_date = '%s' WHERE id = %d",
                todo.getTitle(), todo.getDescription(), todo.getStatus(), todo.getDueDate(), todo.getId());

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("ToDo updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating ToDo: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = String.format("DELETE FROM todos WHERE id = %d", id);

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("ToDo deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting ToDo: " + e.getMessage());
        }
    }
}
