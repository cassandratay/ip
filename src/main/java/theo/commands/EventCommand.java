package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Event;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

public class EventCommand extends Command {
    private String name;
    private String startTime;
    private String endTime;

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
