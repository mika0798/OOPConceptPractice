public class Task {
    private static final int HIGH = 3;
    private static final int MEDIUM = 2;
    private static final int LOW = 1;

    private static final String COMPLETED = "Completed";
    private static final String IN_PROGRESS = "In Progress";
    private static final String NEW = "New";

    private String name;
    private String description;
    private int priority = LOW;
    private String status = NEW;

    public Task(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPriority() {
        return priority;
    }
    public String getStatus() {
        return status;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Priority: " + priority + ", Status: " + status;
    }

}
