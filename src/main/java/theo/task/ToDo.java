package theo.task;

public class ToDo extends Task {
    public ToDo(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "T";
    }

    @Override
    public String getDeadline() {
        return "";
    }
}
