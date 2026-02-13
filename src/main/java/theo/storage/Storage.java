package theo.storage;

import theo.exceptions.TheoException;
import theo.parser.Parser;
import theo.task.Task;
import theo.task.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles saving and loading of the task list to and from a file.
 */
public class Storage {

    private final String filePath;
    private File file;

    /**
     * Constructs a Storage object for the given file path.
     *
     * @param filePath The path to the file used to store the list of tasks.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        file = new File(filePath);
    }

    /**
     * Saves the current TaskList to the file.
     * Creates any necessary parent directories if they do not exist.
     *
     * @param tasks TaskList to save to the file.
     */
    public void save(TaskList tasks) {
        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            FileWriter writer = new FileWriter(filePath);
            for (Task task : tasks.getTasks()) {
                writer.write(task.formatForFile() + System.lineSeparator());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Oh no! Could not save to file");
        }
    }

    /**
     * Loads the list of tasks in the file into an ArrayList.
     * Creates and returns an empty list if the file does not exist.
     */
    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) file.getParentFile().mkdirs();
                file.createNewFile();
                return tasks;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    Task task = Parser.parseFromFile(line);
                    tasks.add(task);
                } catch (TheoException e) {
                    System.out.println("Skipping malformed task line: " + line);
                }
            }
        } catch (IOException exception) {
            System.out.println("Oh no! Could not read from file: " + exception.getMessage());
        }
        return tasks;
    }

}