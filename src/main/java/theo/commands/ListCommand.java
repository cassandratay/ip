package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        ui.showMessage("Here are the tasks in your list:");

        for (int i = 1; i <= tasks.numOfTasks(); i++) {
            ui.showMessage(i + ". " + tasks.getTask(i - 1));
        }
    }
}
