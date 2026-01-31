package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Marks task identified using it's last displayed index from the task list as not done.
 */
public class UnmarkCommand extends Command {
    private int taskNumber;

    /**
     * Constructs an UnmarkCommand for the given task number.
     *
     * @param taskNumber The index of the task to be marked as not done in the task list.
     */
    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = tasks.getTask(taskNumber);
        task.markUndone();

        storage.save(tasks);

        ui.showMessage("Boo! I've marked this task as not done:\n" + task);
    }
}
