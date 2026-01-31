package theo.commands;

import java.util.ArrayList;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

public class FindCommand extends Command {

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        int index = 1;

        for (Task task : tasks.getTasks()) {
            if (task.toString().contains(keyword)) {
                if (index == 1) {
                    ui.showMessage("Great! Here are the matching tasks in your list:");
                }
                ui.showMessage(index + ". " + task.toString());
                index++;
            }
        }

        if (index == 1) {
            ui.showMessage("Aw, there are no matching tasks in your list.\nYou may try another keyword :)");
        }
    }

}
