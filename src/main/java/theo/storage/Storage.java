package theo.storage;

import theo.parser.Parser;
import theo.task.Task;
import theo.task.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;
    private File file;

    public Storage(String filePath) {
        this.filePath = filePath;
        file = new File(filePath);
    }

    public void save(TaskList tasks) {
        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            FileWriter writer = new FileWriter(filePath);
            writer.write(tasks.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Oh no! Could not save to file");
        }
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                return tasks;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Task task = Parser.parseFromFile(line);
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Oh no! Could not save to file");
        }
        return tasks;
    }
}