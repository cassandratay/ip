import java.util.Scanner;

public class Theo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        String[] list = new String[100];

        System.out.println("Hello, I'm Theo\nWhat can I do for you?");

        while (true) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (input.equals("list")) {
                for (int i = 1; i < index; i++) {
                    System.out.println(list[i]);
                }
            } else {
                list[index] = index + ". " + input;
                index++;
                System.out.println("added: " + input);
            }
        }
    }
}
