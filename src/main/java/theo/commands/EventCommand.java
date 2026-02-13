package theo.commands;

import java.time.LocalDateTime;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Event;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Adds an Event task to the task list and saves it to the storage file.
 */
public class EventCommand extends Command {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /**
     * Constructs an EventCommand with the given task name and deadline.
     *
     * @param name The name of the Event task.
     * @param startTime The start time of the Event task.
     * @param endTime The end time of the Event task.
     */
    public EventCommand(String name, LocalDateTime startTime, LocalDateTime endTime) {
        assert name != null : "Event name should not be null";
        assert startTime != null : "Event start time should not be null";
        assert endTime != null : "Event end time should not be null";
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = new Event(name, startTime, endTime);
        tasks.addTask(task);
        storage.save(tasks);

        return "Got it. I've added this task:\n" + task +
                "\nNow you have " + tasks.numOfTasks() + " task(s) in the list.";
    }

}
