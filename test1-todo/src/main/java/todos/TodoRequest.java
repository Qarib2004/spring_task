package todos;

import java.time.LocalDateTime;

public class TodoRequest {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Boolean isDone;
    private Integer projectId;

   // private int loveNumber;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public TodoRequest() {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isDone = isDone;
        this.projectId = projectId;
    }

    public TodoRequest(String title, String description, LocalDateTime dueDate, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isDone = isDone;
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


    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "TodoRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", isDone=" + isDone +
                '}';
    }
}

