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
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        if (tasks.getTasks().isEmpty()) {
            return "You have no tasks! ;)";
        }

        StringBuilder result = new StringBuilder();
        result.append("Here are the tasks in your list:");

        for (int i = 1; i <= tasks.numOfTasks(); i++) {
            result.append("\n").append(i).append(". ").append(tasks.getTask(i - 1));
    }

        return result.toString();
    }

}
