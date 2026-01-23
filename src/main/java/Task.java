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

    @Override
    public String toString() {
        if (done) {
            return "[X] " + this.name;
        } else {
            return "[ ] " + this.name;
        }
    }
}
