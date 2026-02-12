package theo.commands;

import theo.exceptions.TheoException;
import theo.storage.Storage;
import theo.task.Task;
import theo.task.TaskList;
import theo.task.ToDo;
import theo.ui.Ui;

/**
 * Adds a ToDo task to the task list and saves it to the storage file.
 */
public class ToDoCommand extends Command {

    private String name;

    /**
     * Constructs a ToDoCommand with the given task name.
     *
     * @param name The name of the ToDo task.
     */
    public ToDoCommand(String name) {
        assert name != null : "Todo name should not be null";
        this.name = name;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = new ToDo(name);
        tasks.addTask(task);
        storage.save(tasks);

        return "Got it. I've added this task:\n" + task +
                "\nNow you have " + tasks.numOfTasks() + " task(s) in the list.";
    }

}
