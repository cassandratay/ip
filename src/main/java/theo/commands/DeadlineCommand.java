package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Deadline;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Adds a Deadline task to the task list and saves it to the storage file.
 */
public class DeadlineCommand extends Command {

    private String name;
    private String deadline;

    /**
     * Constructs a DeadlineCommand with the given task name and deadline.
     *
     * @param name The name of the Deadline task.
     * @param deadline The deadline of the Deadline task.
     */
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
