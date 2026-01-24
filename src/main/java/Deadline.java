public class Deadline extends Task {
    String deadline;

    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String getType() {
        return "D";
    }

    @Override
    public String getDeadline() {
        String[] deadlineArray = deadline.split(" ", 2);
        return "(" + deadlineArray[0] + ": " + deadlineArray[1] + ")";
    }
}
