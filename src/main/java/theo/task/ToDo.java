package theo.task;

/**
 * Represents a ToDo task, which has no specific deadline or time.
 */
public class ToDo extends Task {

    /**
     * Constructs a ToDo task with the given name.
     *
     * @param name The name of the ToDo task.
     */
    public ToDo(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "T";
    }

    @Override
    public String getDeadline() {
        return "";
    }

}
