package todos;

import todos.Exception.DuplicateDataException;
import todos.Exception.NegativeNumberException;
import todos.Exception.NotNullException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository{


//    public List<TodoRequest> getTodosWithProjects(String joinType) {
//        String query = ;
//
//        List<TodoRequest> todos = new ArrayList<>();
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)) {
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    TodoRequest todo = new TodoRequest();
//                    todo.setProjectId(rs.getInt("projectId"));
//                    todo.setTitle(rs.getString("title"));
//                    todo.setDescription(rs.getString("description"));
//                    todo.setDueDate(DateUtils.toLocalDate(rs.getTimestamp("dueDate")));
//                    todo.setDone(rs.getBoolean("isDone"));
//                    todos.add(todo);
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return todos;
//    }

//    public void cursor(){
//        try (Connection conn = Driver;
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT column1, column2 FROM table_name")) {
//
//            while (rs.next()) {
//                String column1 = rs.getString("column1");
//                String column2 = rs.getString("column2");
//                // Ваши операции с данными
//                System.out.println("Column1: " + column1 + ", Column2: " + column2);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void insert(TodoRequest todoRequest) {
        String insert = "INSERT INTO mavenTest(projectId,title,description,dueDate,isDone) VALUES(?,?,?,?,?);";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setInt(1,todoRequest.getProjectId());
            preparedStatement.setString(2,todoRequest.getTitle());
            preparedStatement.setString(3,todoRequest.getDescription());
            preparedStatement.setDate(4, DateUtils.toSqlDate(todoRequest.getDueDate()));
            preparedStatement.setBoolean(5,todoRequest.getDone());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            if(e.getSQLState().equals("23505")) {
                throw new DuplicateDataException(todoRequest.getTitle() + " already exists");
            }else if(e.getSQLState().equals("23502")){
                throw new NotNullException(todoRequest.getTitle() + "give title");
            }else {
                System.out.println(e.getMessage());
            }
        }
    }


    public TodoRequest select(int id) {
        String select = "SELECT * FROM mavenTest WHERE id = ? ";
        TodoRequest todo = null;
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(select)){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                todo = new TodoRequest();
                todo.setProjectId(rs.getInt("projectId"));
                todo.setTitle(rs.getString("title"));
                todo.setDescription(rs.getString("description"));
                todo.setDueDate(DateUtils.toLocalDate(rs.getTimestamp("dueDate")));
                todo.setDone(rs.getBoolean("isDone"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return todo;
    }

    public List<TodoRequest> selectAll() {
        String sql = "SELECT * FROM mavenTest";
        List<TodoRequest> todos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TodoRequest todo = new TodoRequest();
                todo.setProjectId(rs.getInt("projectId"));
                todo.setTitle(rs.getString("title"));
                todo.setDescription(rs.getString("description"));
                todo.setDueDate(DateUtils.toLocalDate(rs.getTimestamp("dueDate")));
                todo.setDone(rs.getBoolean("isDone"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todos;
    }


    public void update(int id,TodoRequest todoRequest) {
        String update = "UPDATE mavenTest SET title = ?, description = ?, dueDate = ?, isDone = ? WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(update)){
            preparedStatement.setString(1, todoRequest.getTitle());
            preparedStatement.setString(2, todoRequest.getDescription());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(todoRequest.getDueDate()));
            preparedStatement.setBoolean(4, todoRequest.getDone());
            preparedStatement.setTimestamp(5, DateUtils.toSqlTimestamp(LocalDateTime.now()));
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM mavenTest WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

