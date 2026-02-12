package theo.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an Event task, which has specific start and end times.
 */
public class Event extends Task {

    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

    /**
     * Constructs an Event task with the given name, start time and end time.
     *
     * @param name The name of the Event task.
     * @param startString The start time of the Event task.
     * @param endString The start time of the Event task.
     */
    public Event(String name, String startString, String endString) {
        super(name);
        assert startString != null : "Start time should not be null";
        assert endString != null : "End time should not be null";
        this.startTime = LocalDateTime.parse(startString, INPUT_FORMAT);
        this.endTime = LocalDateTime.parse(endString, INPUT_FORMAT);
        assert startTime.isBefore(endTime) : "Start must be before end";

    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String getDeadline() {
        return " (from: " + startTime.format(OUTPUT_FORMAT) + " to: " + endTime.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public boolean isOnDate(LocalDate date) {
        LocalDate startDate = startTime.toLocalDate();
        LocalDate endDate = endTime.toLocalDate();
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

}