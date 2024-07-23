package todos;

import java.sql.*;

public class ProjectRepository {
    final TodoRepository todoRepository;
    public ProjectRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    void saveProject(Project project){
        String insertProject = "INSERT INTO projects(name,description) VALUES(?,?);";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(insertProject, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,project.getName());
            ps.setString(2,project.getDescription());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id  = rs.getInt(1);
                project.setId(id);
            }
            for(TodoRequest todo: project.getTodos()){
                todo.setProjectId(project.getId());
                todoRepository.insert(todo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
