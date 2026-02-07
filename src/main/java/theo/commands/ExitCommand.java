package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        return "Bye. Hope to see you again soon!";
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
