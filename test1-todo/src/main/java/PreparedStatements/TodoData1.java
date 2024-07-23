package PreparedStatements;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TodoData1 {
    private int id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime dueDate;

    public TodoData1(int id, String title, String description, String status, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public TodoData1(String title, String description, String status, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public Timestamp getDueDateTimestamp() {
        return Timestamp.valueOf(dueDate);
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "TodoData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
