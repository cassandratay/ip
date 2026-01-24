public class Event extends Task {
    String start;
    String end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String getDeadline() {
        String[] startArray = start.split(" ", 2);
        String[] endArray = end.split(" ", 2);
        return " (" + startArray[0] + ": " + startArray[1] + " " + endArray[0] + ": " + endArray[1] + ")";
    }
}
