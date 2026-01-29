public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        ui.showMessage("Here are the tasks in your list:");

        for (int i = 1; i <= tasks.numOfTasks(); i++) {
            ui.showMessage(i + ". " + tasks.getTask(i - 1));
        }
    }
}
