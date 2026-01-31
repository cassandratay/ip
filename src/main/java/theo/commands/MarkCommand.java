package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Marks task identified using it's last displayed index from the task list as done.
 */
public class MarkCommand extends Command {

    private int taskNumber;

    /**
     * Constructs a MarkCommand for the given task number.
     *
     * @param taskNumber The index of the task to be marked as done in the task list.
     */
    public MarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = tasks.getTask(taskNumber);
        task.markDone();

        storage.save(tasks);

        ui.showMessage("Nice! I've marked this task as done:\n" + task);
    }

}
