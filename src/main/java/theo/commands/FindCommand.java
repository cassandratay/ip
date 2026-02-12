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
        assert keyword != null : "Keyword should not be null";
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        int matchCount = 0;
        StringBuilder result = new StringBuilder();

        for (Task task : tasks.getTasks()) {
            if (task.toString().contains(keyword)) {
                if (matchCount == 0) {
                    result.append("Great! Here are the matching tasks in your list:\n");
                }
                matchCount++;
                result.append(matchCount)
                        .append(". ")
                        .append(task)
                        .append("\n");
            }
        }

        if (matchCount == 0) {
            result.append("Aw, there are no matching tasks in your list.\n")
                    .append("You may try another keyword :)");
        }

        return result.toString();
    }

}
