import java.util.Scanner;

public class Ui {
    private final Scanner sc = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Hello, I'm Theo\nWhat can I do for you?");
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(TheoException e) {
        System.out.println(e.getMessage());
    }

    public String readCommand() {
        return sc.nextLine();
    }
}

