import java.util.ArrayList;
import java.util.Scanner;

public class Theo {
    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    public Theo(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (TheoException e) {
            // ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                // ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parseInput(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (TheoException e) {
                ui.showError(e);
            } finally {
                // ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Theo("data/tasks.txt").run();
    }
}
