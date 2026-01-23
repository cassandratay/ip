import java.util.Scanner;

public class Theo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        Task[] list = new Task[100];

        System.out.println("Hello, I'm Theo\nWhat can I do for you?");

        while (true) {
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");
            String req = inputArray[0];

            if (req.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (req.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 1; i < index; i++) {
                    System.out.println(i + ". " + list[i]);
                }
            } else if (req.equals("mark")) {
                int num = Integer.parseInt(inputArray[1]);
                Task task = list[num];
                task.markDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(task);
            } else if (req.equals("unmark")) {
                int num = Integer.parseInt(inputArray[1]);
                Task task = list[num];
                task.markUndone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(task);
            } else {
                Task newTask = new Task(input);
                list[index] = newTask;
                index++;
                System.out.println("added: " + input);
            }
        }
    }
}
