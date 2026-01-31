package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.TaskList;
import theo.ui.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        ui.showExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
