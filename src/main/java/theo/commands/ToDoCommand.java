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
        this.name = name;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = new ToDo(name);
        tasks.addTask(task);
        storage.save(tasks);

        ui.showMessage("Got it. I've added this task:\n" + task);
        ui.showMessage("Now you have " + tasks.numOfTasks() + " task(s) in the list.");
    }

}
