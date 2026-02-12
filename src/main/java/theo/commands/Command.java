package theo.commands;

import theo.exceptions.TheoException;
import theo.task.TaskList;
import theo.ui.Ui;
import theo.storage.Storage;

/**
 * Represents an executable command.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param tasks   The current task list
     * @param ui      The UI handler
     * @param storage The storage handler
     * @return A message describing the result of executing the command
     * @throws TheoException If there is an error executing the command
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException;

    public boolean isExit() {
        return false;
    }

}
