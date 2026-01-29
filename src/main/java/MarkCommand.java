public class MarkCommand extends Command {
    private int taskNumber;

    public MarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TheoException {
        Task task = tasks.getTask(taskNumber);
        task.markDone();

        storage.save(tasks);

        ui.showMessage("Nice! I've marked this task as done:\n" + task);
    }
}
