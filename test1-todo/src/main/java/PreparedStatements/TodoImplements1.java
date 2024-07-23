package PreparedStatements;

import org.todo.test.DatabaseConnection;
import org.todo.test.TodoData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoImplements1 implements Todoimp1 {
    @Override
    public void create(TodoData todo) {
        String sql = "INSERT INTO todos (title, description, status, due_date) VALUES (?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,todo.getTitle());
            stmt.setString(2,todo.getDescription());
            stmt.setString(2,todo.getStatus());
            stmt.setDate(4, Date.valueOf(todo.getDueDate()));
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
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                    ResultSet rs = stmt.executeQuery(sql);

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
        String sql = "UPDATE todos SET title = ?, description = ?, status = ?, due_date = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,todo.getTitle());
            stmt.setString(2,todo.getDescription());
            stmt.setString(3,todo.getStatus());
            stmt.setDate(4, Date.valueOf(todo.getDueDate()));
            stmt.executeUpdate(sql);
            System.out.println("ToDo updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating ToDo: " + e.getMessage());
        }
    }


    @Override
    public void delete(int id,TodoData todo) {
        String sql = "DELETE FROM todos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate(sql);
            System.out.println("ToDo deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting ToDo: " + e.getMessage());
        }
    }
}
