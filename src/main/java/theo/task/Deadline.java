package theo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Deadline task, which has a specific deadline.
 */
public class Deadline extends Task {

    private final LocalDateTime deadline;

    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

    /**
     * Constructs an Deadline task with the given name and deadline.
     *
     * @param name The name of the Deadline task.
     * @param deadline The deadline of the Deadline task.
     */
    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = LocalDateTime.parse(deadline, INPUT_FORMAT);
    }

    @Override
    public String getType() {
        return "D";
    }

    @Override
    public String getDeadline() {
        return " (by: " + deadline.format(OUTPUT_FORMAT) + ")";
    }

}
