package queueInterface;

public class Task implements Comparable<Task> {
    private int id;
    private String description;
    private int priority;

    public Task(int id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    /*This method is required because the Task class implements the Comparable<Task> interface.
     It compares two tasks based on their priorities (ascending order).
     The method returns a negative value if the current task’s priority is less than the other task’s priority, a positive value if greater, and 0 if equal.*/
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", description='" + description + "', priority=" + priority + "}";
    }
}
