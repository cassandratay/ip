package theo.commands;

import theo.exceptions.TheoException;
import theo.task.TaskList;
import theo.ui.Ui;
import theo.storage.Storage;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException;

    public boolean isExit() {
        return false;
    }

}
