//import todos.DatabaseConnection;
//import todos.TodoRequest;
//
//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ClassTodoRepository {
//
//    public void saveTodoRequest(TodoRequest todoRequest, int projectId) {
//        String insertTodo = "INSERT INTO todos(projectId, title, description, dueDate, isDone) VALUES(?, ?, ?, ?, ?);";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement ps = connection.prepareStatement(insertTodo, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setInt(1,todoRequest.getProjectId());
//            ps.setString(2, todoRequest.getTitle());
//            ps.setString(3, todoRequest.getDescription());
//            ps.setTimestamp(4, Timestamp.valueOf(todoRequest.getDueDate()));
//            ps.setBoolean(5, todoRequest.getDone());
//            ps.executeUpdate();
//            // Получение сгенерированного идентификатора (опционально)
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                int id = rs.getInt(1);  // Получаем сгенерированный ID
//                System.out.println("Generated ID: " + id);  // Выводим ID, если нужно
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<TodoRequest> getTodosByProjectId(int projectId) {
//        String selectTodos = "SELECT * FROM todos WHERE project_id = ?;";
//        List<TodoRequest> todos = new ArrayList<>();
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement ps = connection.prepareStatement(selectTodos)) {
//            ps.setInt(1, projectId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                TodoRequest todoRequest = new TodoRequest();
//                todoRequest.setTitle(rs.getString("title"));
//                todoRequest.setDescription(rs.getString("description"));
//                todoRequest.setDueDate(rs.getTimestamp("due_date").toLocalDateTime());
//                todoRequest.setDone(rs.getBoolean("is_done"));
//                todos.add(todoRequest);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return todos;
//    }
//
//    public void updateTodoRequest(int todoId, TodoRequest todoRequest) {
//        String updateTodo = "UPDATE todos SET title = ?, description = ?, due_date = ?, is_done = ? WHERE id = ?;";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement ps = connection.prepareStatement(updateTodo)) {
//            ps.setString(1, todoRequest.getTitle());
//            ps.setString(2, todoRequest.getDescription());
//            ps.setTimestamp(3, Timestamp.valueOf(todoRequest.getDueDate()));
//            ps.setBoolean(4, todoRequest.getDone());
//            ps.setInt(5, todoId);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void deleteTodoRequest(int todoId) {
//        String deleteTodo = "DELETE FROM todos WHERE id = ?;";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement ps = connection.prepareStatement(deleteTodo)) {
//            ps.setInt(1, todoId);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
