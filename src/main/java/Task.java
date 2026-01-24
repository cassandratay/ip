public class Task {
    String name;
    boolean done;

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

    public String getType() {
        return "";
    }

    public String getDeadline() {
        return "";
    }

    @Override
    public String toString() {
        if (done) {
            return "[" + getType() + "][X] " + this.name + " " + getDeadline();
        } else {
            return "[" + getType() + "][ ] " + this.name + " " + getDeadline();
        }
    }
}
