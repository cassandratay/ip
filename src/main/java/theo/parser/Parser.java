package theo.parser;

import theo.commands.*;
import theo.exceptions.TheoException;
import theo.task.Deadline;
import theo.task.Event;
import theo.task.Task;
import theo.task.ToDo;

public class Parser {
    public static Command parseInput(String input) {
        String[] inputParts = input.split(" ", 2);
        String command = inputParts[0];

        switch (command) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "mark": {
                if (inputParts.length == 1) { // if only "mark"
                    throw new TheoException("Huh? The index of the task has to be specified.");
                }
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                return new MarkCommand(taskNumber);
            }
            case "unmark": {
                if (inputParts.length == 1) { // if only "mark"
                    throw new TheoException("Huh? The index of the task has to be specified.");
                }
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                return new UnmarkCommand(taskNumber);
            }
            case "todo": {
                if (inputParts.length == 1) { // if only "todo"
                    throw new TheoException("Huh? The description cannot be empty.");
                }
                String taskName = inputParts[1];
                return new ToDoCommand(taskName);
            }
            case "deadline": {
                if (inputParts.length == 1) {   // if only "deadline"
                    throw new TheoException("Huh? The description cannot be empty.");   // no name
                }
                String description = inputParts[1];
                String[] descriptionParts = description.split(" /by ", 2);
                if (descriptionParts.length == 1) {    // if only "deadline [taskname]"
                    throw new TheoException("Huh? The deadline has to be specified.");
                }
                String name = descriptionParts[0];
                String deadline = descriptionParts[1];
                return new DeadlineCommand(name, deadline);
            }
            case "event": {
                if (inputParts.length == 1) {   // if only "event"
                    throw new TheoException("Huh? The description cannot be empty.");
                }
                String description = inputParts[1];
                String[] descriptionParts = description.split(" /from ", 2);

                String name = descriptionParts[0];
                String timing = descriptionParts[1];
                String[] timingParts = timing.split(" /to ", 2);
                String startTime = timingParts[0];
                String endTime = timingParts[1];
                return new EventCommand(name, startTime, endTime);
            }
            case "delete": {
                if (inputParts.length == 1) {
                    throw new TheoException("Huh? The task to delete has to be specified.");
                }
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                return new DeleteCommand(taskNumber);
            }
            default:
                throw new TheoException("Huh? I don't quite know what you mean by that...");
        }
    }

    public static Task parseFromFile(String fileLine) {
        String[] taskParts = fileLine.split(" \\| ");
        if (taskParts.length < 3) {
            throw new TheoException("Invalid task format in file: " + fileLine);
        }

        String type = taskParts[0];
        boolean isDone = taskParts[1].equals("1");
        String name = taskParts[2];

        Task task;

        switch (type) {
            case "T":
                task = new ToDo(name);
                break;

            case "D":
                if (taskParts.length < 4) {
                    throw new TheoException("theo.task.Deadline missing time: " + fileLine);
                }
                String deadline = taskParts[3];
                task = new Deadline(name, deadline);
                break;

            case "E":
                if (taskParts.length < 5) {
                    throw new TheoException("theo.task.Event missing start or end time: " + fileLine);
                }
                String startTime = taskParts[3];
                String endTime = taskParts[4];
                task = new Event(name, startTime, endTime);
                break;

            default:
                throw new TheoException("Unknown task type in file: " + type);
        }
        return task;
    }
}
