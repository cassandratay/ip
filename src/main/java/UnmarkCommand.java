public class UnmarkCommand extends Command {
    private int taskNumber;

    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = tasks.getTask(taskNumber);
        task.markUndone();

        storage.save(tasks);

        ui.showMessage("Nice! I've marked this task as done:\n" + task);
    }
}
