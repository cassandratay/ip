package theo.task;

import java.time.LocalDate;

/**
 * Represents a task in the task list.
 */
public abstract class Task {

    private final String name;
    private boolean isDone;

    /**
     * Constructs a Task with the given name.
     * The task is initially marked as undone.
     *
     * @param name The name or description of the task.
     */
    public Task(String name) {
        assert name != null : "Task name should not be null";
        this.name = name;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markUndone() {
        this.isDone = false;
    }

    /**
     * Formats the task for file.
     */
    public abstract String formatForFile();

    public abstract String getType();

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    protected String getDisplayTime() {
        return "";
    }

    public boolean isOnDate(LocalDate date) {
        return false;
    }

    @Override
    public String toString() {
        if (name.isEmpty()) {
            throw new IllegalStateException("Name should not be empty");
        }

        return "[" + getType() + "][" + (isDone ? "X" : " ") + "] " + name + getDisplayTime();
    }

}
