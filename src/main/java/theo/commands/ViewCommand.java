package theo.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Task;
import theo.task.TaskList;
import theo.ui.Ui;

public class ViewCommand extends Command {

    private final LocalDate date;

    public ViewCommand(String dateString) {
        assert dateString != null : "Date should not be null";
        this.date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d/M/yyyy"));
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        StringBuilder result = new StringBuilder();

        for (Task task : tasks.getTasks()) {
            if (task.isOnDate(date)) {
                result.append("\n").append(task);
            }
        }

        if (result.isEmpty()) {
            return "No tasks scheduled on " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        } else {
            return "Schedule for " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ":" + result.toString();
        }
    }

}
