package theo.ui;

import theo.exceptions.TheoException;

import java.util.Scanner;

/**
 * UI of the application.
 */
public class Ui {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Displays welcome message when the chatbot starts.
     */
    public void showWelcome() {
        System.out.println("Hello, I'm Theo\nWhat can I do for you?");
    }

    /**
     * Displays a goodbye message when the user exits the chatbot.
     */
    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Shows message to the user
     *
     * @param message Message to show.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Shows error message to the user
     *
     * @param exception TheoException containing the error message.
     */
    public void showError(TheoException exception) {
        System.out.println(exception.getMessage());
    }

    /**
     * Reads a full line of input from the user.
     *
     * @return The input string entered by the user.
     */
    public String readCommand() {
        return sc.nextLine();
    }
}

