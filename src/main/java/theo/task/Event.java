package theo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an Event task, which has specific start and end times.
 */
public class Event extends Task {

    private final LocalDateTime start;
    private final LocalDateTime end;

    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

    /**
     * Constructs an Event task with the given name, start time and end time.
     *
     * @param name The name of the Event task.
     * @param start The start time of the Event task.
     * @param end The start time of the Event task.
     */
    public Event(String name, String start, String end) {
        super(name);
        this.start = LocalDateTime.parse(start, INPUT_FORMAT);
        this.end = LocalDateTime.parse(end, INPUT_FORMAT);
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String getDeadline() {
        return " (from: " + start.format(OUTPUT_FORMAT) + " to: " + end.format(OUTPUT_FORMAT) + ")";
    }

}