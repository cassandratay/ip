import java.util.ArrayList;
import java.util.Scanner;

public class Theo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();

        System.out.println("Hello, I'm Theo\nWhat can I do for you?");

        while (true) {
            String input = sc.nextLine();
            String[] inputArray = input.split(" ", 2);
            String req = inputArray[0];

            try {
                if (req.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (req.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 1; i <= list.size(); i++) {
                        System.out.println(i + ". " + list.get(i - 1));
                    }
                } else if (req.equals("mark")) {
                    int num = Integer.parseInt(inputArray[1]) - 1;
                    Task task = list.get(num);
                    task.markDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(task);
                } else if (req.equals("unmark")) {
                    int num = Integer.parseInt(inputArray[1]) - 1;
                    Task task = list.get(num);
                    task.markUndone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(task);
                } else if (req.equals("todo")) {
                    if (inputArray.length == 1) {
                        throw new TheoException("Huh? The description cannot be empty.");
                    }
                    String name = inputArray[1];
                    Task newTask = new ToDo(name);
                    list.add(newTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newTask);
                    System.out.println("Now you have " + list.size() + " task(s) in the list.");
                } else if (req.equals("deadline")) {
                    if (inputArray.length == 1) {
                        throw new TheoException("Huh? The description cannot be empty.");
                    }
                    String desc = inputArray[1];
                    String[] descArray = desc.split(" /", 2);
                    if (descArray.length == 1) {
                        throw new TheoException("Huh? The deadline has to be specified.");
                    }
                    String name = descArray[0];
                    String deadline = descArray[1];
                    Task newTask = new Deadline(name, deadline);
                    list.add(newTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newTask);
                    System.out.println("Now you have " + list.size() + " task(s) in the list.");
                } else if (req.equals("event")) {
                    if (inputArray.length == 1) {
                        throw new TheoException("Huh? The description cannot be empty.");
                    }
                    String desc = inputArray[1];
                    String[] descArray = desc.split(" /", 3);
                    if (descArray.length <= 2) {
                        throw new TheoException("Huh? Both start and end times has to be specified.");
                    }
                    String name = descArray[0];
                    String start = descArray[1];
                    String end = descArray[2];
                    Task newTask = new Event(name, start, end);
                    list.add(newTask);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newTask);
                    System.out.println("Now you have " + list.size() + " task(s) in the list.");
                } else if (req.equals("delete")) {
                    if (inputArray.length == 1) {
                        throw new TheoException("Huh? The task to delete has to be specified.");
                    }
                    int num = Integer.parseInt(inputArray[1]) - 1;
                    Task task = list.remove(num);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(task);
                    System.out.println("Now you have " + list.size() + " task(s) in the list.");
                } else {
                    throw new TheoException("Huh? I don't quite know what you mean by that...");
                }
            } catch (TheoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
