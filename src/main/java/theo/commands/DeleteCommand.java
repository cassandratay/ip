package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Deletes a task identified using it's last displayed index from the task list.
 */
public class DeleteCommand extends Command {

    private int taskNumber;

    /**
     * Constructs a DeleteCommand for the given task number.
     *
     * @param taskNumber The index of the task to delete in the task list.
     */
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        if (taskNumber < 0 || taskNumber >= tasks.numOfTasks()) {
            throw new TheoException("Invalid task number.");
        }

        Task task = tasks.getTask(taskNumber);
        tasks.deleteTask(taskNumber);

        storage.save(tasks);

        return "Noted. I've removed this task:\n" + task +
                "\nNow you have " + tasks.numOfTasks() + " task(s) in the list.";
    }

}
