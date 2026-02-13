package theo.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import theo.commands.Command;
import theo.commands.DeadlineCommand;
import theo.commands.DeleteCommand;
import theo.commands.EventCommand;
import theo.commands.ExitCommand;
import theo.commands.FindCommand;
import theo.commands.ListCommand;
import theo.commands.MarkCommand;
import theo.commands.ToDoCommand;
import theo.commands.UnmarkCommand;
import theo.commands.ViewCommand;
import theo.exceptions.TheoException;
import theo.task.Deadline;
import theo.task.Event;
import theo.task.Task;
import theo.task.ToDo;

/**
 * Parses user input.
 */
public class Parser {

    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    /**
     * Parses user input into command for execution.
     *
     * @param input Full user input string.
     * @return The command based on the user input.
     */
    public static Command parseInput(String input) {
        String[] inputParts = input.split(" ", 2);

        String command = inputParts[0];

        switch (command) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark": {
            return new MarkCommand(parseTaskNumber(inputParts));
        }
        case "unmark": {
            return new UnmarkCommand(parseTaskNumber(inputParts));
        }
        case "todo": {
            String taskName = parseDescription(inputParts, command);
            return new ToDoCommand(taskName);
        }
        case "deadline": {
            String description = parseDescription(inputParts, command);
            String[] descriptionParts = description.split(" /by ", 2);
            if (descriptionParts.length == 1) {
                throw new TheoException("Deadline must include '/by' followed by date/time.");
            }
            String name = descriptionParts[0];
            LocalDateTime deadline = parseDateTime(descriptionParts[1]);
            return new DeadlineCommand(name, deadline);
        }
        case "event": {
            String description = parseDescription(inputParts, command);
            String[] descriptionParts = description.split(" /from ", 2);
            String name = descriptionParts[0];
            String timing = descriptionParts[1];
            String[] timingParts = timing.split(" /to ", 2);
            LocalDateTime startTime = parseDateTime(timingParts[0]);
            LocalDateTime endTime = parseDateTime(timingParts[1]);
            return new EventCommand(name, startTime, endTime);
        }
        case "delete": {
            return new DeleteCommand(parseTaskNumber(inputParts));
        }
        case "find": {
            return new FindCommand(parseKeyword(inputParts));
        }
        case "view": {
            return new ViewCommand(parseDescription(inputParts, command));
        }
        default:
            throw new TheoException("Huh? I don't quite know what you mean by that...");
        }
    }

    /**
     * Parses the task number from user input for commands like "mark", "unmark", or "delete".
     *
     * @param inputParts The user input split into parts (command and arguments).
     * @return The zero-based task index corresponding to the user's input.
     * @throws TheoException If no task number is provided or if it is not a valid integer.
     */
    private static int parseTaskNumber(String[] inputParts) {
        if (inputParts.length < 2) {
            throw new TheoException("Task number must be specified.");
        }
        try {
            return Integer.parseInt(inputParts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new TheoException("Task number must be a valid integer.");
        }
    }

    /**
     * Parses the search keyword from user input for the "find" command.
     *
     * @param inputParts The user input split into parts (command and arguments).
     * @return The keyword to search for.
     * @throws TheoException If no keyword is provided in the input.
     */
    private static String parseKeyword(String[] inputParts) {
        if (inputParts.length < 2) {
            throw new TheoException("Huh? A keyword of the task you are searching for has to be specified.");
        }
        return inputParts[1];
    }

    /**
     * Parses the description from user input for commands like "todo", "deadline", or "event".
     *
     * @param inputParts The user input split into parts (command and arguments).
     * @return The description text.
     * @throws TheoException If the description is missing or blank.
     */
    private static String parseDescription(String[] inputParts, String command) {
        if (inputParts.length < 2 || inputParts[1].isBlank()) {
            throw new TheoException("Huh? The description for '" + command + "' cannot be empty.");
        }
        return inputParts[1];
    }

    /**
     * Parses a single line from the storage file into a Task object.
     *
     * @param fileLine A single line from the storage file representing a task.
     * @return A Task object corresponding to the data in the file line.
     * @throws TheoException If the file line is in an invalid format,
     *                       if a required time field is missing,
     *                       or if the task type is unknown.
     */
    public static Task parseFromFile(String fileLine) {
        String[] taskParts = fileLine.split(" \\| ");
        assert taskParts.length >= 3 : "File line must have type, status, and name";

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
            LocalDateTime deadlineTime = parseDateTime(taskParts[3]);
            task = new Deadline(name, deadlineTime);
            break;

        case "E":
            if (taskParts.length < 5) {
                throw new TheoException("theo.task.Event missing start or end time: " + fileLine);
            }
            LocalDateTime startTime = parseDateTime(taskParts[3]);
            LocalDateTime endTime = parseDateTime(taskParts[4]);
            task = new Event(name, startTime, endTime);
            break;

        default:
            throw new TheoException("Unknown task type in file: " + type);
        }

        if (isDone) {
            task.markDone();
        }

        return task;
    }

    /**
     * Parses the dateTime String from user input for commands like "deadline", or "event".
     *
     * @param dateTime The dateTime string to be parsed.
     * @return The LocalDateTime object corresponding to the parsed dateTime string.
     * @throws TheoException If the dateTime string is in an invalid format.
     */
    private static LocalDateTime parseDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, INPUT_FORMAT);
        } catch (java.time.format.DateTimeParseException e) {
            throw new TheoException("Invalid date/time format: " + dateTime +
                    ". Use d/M/yyyy HHmm, e.g., 13/2/2026 1530.");
        }
    }

}
