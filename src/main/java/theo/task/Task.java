package theo.task;

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

    public abstract String getType();

    public abstract String getDeadline();

    @Override
    public String toString() {
        if (name.isEmpty()) {
            return "Huh?";
        }

        return "[" + getType() + "][" + (isDone ? "X] " : " ] ") + this.name + getDeadline();
    }

    /**
     * Returns a string representation of the task formatted for saving to the storage file.
     * The format is: TaskType | isDone | name | deadline/time info.
     *
     * @return A string containing the task information to be saved to the storage file.
     */
    public String formatString() {
        return getType() + " | " + (isDone ? "1" : "0") + " | " + this.name + getDeadline();
    }

}
