package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Deadline;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

public class DeadlineCommand extends Command {
    private String name;
    private String deadline;

    public DeadlineCommand(String name, String deadline) {
        this.name = name;
        this.deadline = deadline;

    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = new Deadline(name, deadline);
        tasks.addTask(task);
        storage.save(tasks);

        ui.showMessage("Got it. I've added this task:\n" + task);
        ui.showMessage("Now you have " + tasks.numOfTasks() + " task(s) in the list.");
    }
}
