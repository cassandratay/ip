package theo.commands;

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
    private String startTime;
    private String endTime;

    /**
     * Constructs an EventCommand with the given task name and deadline.
     *
     * @param name The name of the Event task.
     * @param startTime The start time of the Event task.
     * @param endTime The end time of the Event task.
     */
    public EventCommand(String name, String startTime, String endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = new Event(name, startTime, endTime);
        tasks.addTask(task);
        storage.save(tasks);

        ui.showMessage("Got it. I've added this task:\n" + task);
        ui.showMessage("Now you have " + tasks.numOfTasks() + " task(s) in the list.");
    }

}
