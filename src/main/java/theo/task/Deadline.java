package theo.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Deadline task, which has a specific deadline.
 */
public class Deadline extends Task {

    private final LocalDateTime deadline;

    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
    private static final DateTimeFormatter FILE_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");


    /**
     * Constructs a Deadline task with the given name and deadline.
     *
     * @param name The name of the Deadline task.
     * @param deadline The deadline of the Deadline task.
     */
    public Deadline(String name, LocalDateTime deadline) {
        super(name);
        assert deadline != null : "Deadline should not be null";
        this.deadline = deadline;
    }

    @Override
    public String getType() {
        return "D";
    }

    @Override
    public boolean isOnDate(LocalDate date) {
        LocalDate deadlineInLocalDate = deadline.toLocalDate();
        return deadlineInLocalDate.equals(date) || deadlineInLocalDate.isAfter(date);
    }

    @Override
    protected String getDisplayTime() {
        return " (by: " + deadline.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String formatForFile() {
        return getType() + " | " + (isDone() ? "1" : "0") + " | " + getName() + " | "
                + deadline.format(FILE_FORMAT);
    }
}
