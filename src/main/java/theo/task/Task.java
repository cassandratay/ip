package theo.task;

public abstract class Task {
    private final String name;
    private boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public void markDone() {
        this.done = true;
    }

    public void markUndone() {
        this.done = false;
    }

    public abstract String getType();

    public abstract String getDeadline();

    @Override
    public String toString() {
        if (name.isEmpty()) {
            return "Huh? ";
        }

        return "[" + getType() + "][" + (done ? "X] " : " ] ") + this.name + getDeadline();
    }

    public String formatString() {
        return getType() + " | " + (done ? "1" : "0") + " | " + this.name + getDeadline();
    }
}
