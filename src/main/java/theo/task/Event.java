package theo.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an Event task, which has specific start and end times.
 */
public class Event extends Task {

    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
    private static final DateTimeFormatter FILE_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    /**
     * Constructs an Event task with the given name, start time and end time.
     *
     * @param name The name of the Event task.
     * @param startTime The start time of the Event task.
     * @param endTime The start time of the Event task.
     */
    public Event(String name, LocalDateTime startTime, LocalDateTime endTime) {
        super(name);
        assert startTime != null : "Start time should not be null";
        assert endTime != null : "End time should not be null";
        this.startTime = startTime;
        this.endTime = endTime;
        assert startTime.isBefore(endTime) : "Start must be before end";
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public boolean isOnDate(LocalDate date) {
        LocalDate startDate = startTime.toLocalDate();
        LocalDate endDate = endTime.toLocalDate();
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    @Override
    protected String getDisplayTime() {
        return " (from: " + startTime.format(OUTPUT_FORMAT) + " to: " + endTime.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String formatForFile() {
        return getType() + " | " + (isDone() ? "1" : "0") + " | " + getName() + " | "
                + startTime.format(FILE_FORMAT) + " | " + endTime.format(FILE_FORMAT);
    }

}