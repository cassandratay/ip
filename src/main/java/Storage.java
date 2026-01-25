import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    static String path = "data/theo.txt";

    public static void save(ArrayList<Task> tasks) {
        try {
            File file = new File(path);

            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            FileWriter writer = new FileWriter(path);

            for (Task task : tasks) {
                writer.write(task.formatString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Oh no! Could not save to file");
        }
    }
}