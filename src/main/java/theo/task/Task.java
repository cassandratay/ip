package theo.task;

/**
 * Represents a task in the task list.
 */
public abstract class Task {

    private final String name;
    private boolean done;

    /**
     * Constructs a Task with the given name.
     * The task is initially marked as undone.
     *
     * @param name The name or description of the task.
     */
    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    /**
     * Marks the task as done.
     */
    public void markDone() {
        this.done = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markUndone() {
        this.done = false;
    }

    public abstract String getType();

    public abstract String getDeadline();

    @Override
    public String toString() {
        if (name.isEmpty()) {
            return "Huh?";
        }

        return "[" + getType() + "][" + (done ? "X] " : " ] ") + this.name + getDeadline();
    }

    /**
     * Returns a string representation of the task formatted for saving to the storage file.
     * The format is: TaskType | isDone | name | deadline/time info.
     *
     * @return A string containing the task information to be saved to the storage file.
     */
    public String formatString() {
        return getType() + " | " + (done ? "1" : "0") + " | " + this.name + getDeadline();
    }

}
