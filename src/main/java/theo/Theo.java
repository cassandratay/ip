package theo;

import theo.commands.Command;
import theo.exceptions.TheoException;
import theo.parser.Parser;
import theo.storage.Storage;
import theo.task.TaskList;
import theo.ui.Ui;

/**
 * Entry point of the THEO Chatbot.
 * Initializes the application and starts the interaction with the user.
 */
public class Theo {

    private Storage storage;
    private Ui ui;
    private TaskList tasks;
    private static final String DEFAULT_FILE_PATH = "data/tasks.txt";

    /**
     * Constructs the Theo chatbot with a given file path for task storage.
     */
    public Theo() {
        ui = new Ui();
        storage = new Storage(DEFAULT_FILE_PATH);
        try {
            tasks = new TaskList(storage.load());
        } catch (TheoException e) {
            tasks = new TaskList();
        }
    }

    /**
     * Runs the program until termination.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parseInput(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (TheoException e) {
                ui.showError(e);
            }
        }
    }

    /**
     * The main entry point of the program.
     * Creates a new Theo instance with a default data file and starts it.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new Theo().run();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parseInput(input);
            return c.execute(tasks, ui, storage);
        } catch (TheoException e) {
            ui.showError(e);
            return e.getMessage(); // return an error message to the GUI
        }
    }

}
