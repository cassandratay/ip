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
     * Executes the command
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException;

    public boolean isExit() {
        return false;
    }
}
