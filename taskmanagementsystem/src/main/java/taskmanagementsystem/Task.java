package taskmanagementsystem;

public class Task {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private int userId;
    private String status;

    public Task() {
        // Default constructor
    }

    public Task(int id, String title, String description, String dueDate, String priority, int userId, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.userId = userId;
        this.status = status;
    }

    // Getters and setters for all the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String string) {
        this.priority = string;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getstatus() {
        return status;
    }

    public void setstatus(String string) {
        this.status = string;
    }
    
    public boolean isCompleted() {
        return this.status.equals("Completed");
    }

}