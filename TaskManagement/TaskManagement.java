import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskManagement {
    public static void main(String[] args) {
        HashMap<String, Task> taskBook = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println(
                        "Press 1 to add an entry in the Taskbook," +
                                "\n2 to view all the tasks" +
                                "\n3 to search for tasks with name" +
                                "\n4 to update the status of the task" +
                                "\n5 to delete a task" +
                                "\n6 to sort the tasks by name" +
                                "\n7 to write the tasks onto a file" +
                                "\nAny other key to exit");

                String userAction = scanner.nextLine();

                if (userAction.equals("1")) {
                    System.out.println("Enter the task name: ");
                    String name = scanner.nextLine();

                    if (taskBook.containsKey(name)) {
                        System.out.println("The task with that name already exists, would you" +
                                "like to update? (y/n)");
                        String choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    System.out.println("Enter the task description: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter the task priority" +
                            "\nHigh = 3, Medium = 2, Low = 1");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    priority = priority > 3 ? 1 : priority;

                    Task task = new Task(name, description, priority);
                    taskBook.put(name, task);
                    System.out.println("Task added successfully!");

                } else if  (userAction.equals("2")) {
                    for (String name : taskBook.keySet()) {
                        System.out.println("name: " + taskBook.get(name));
                    }

                } else if (userAction.equals("3")) {
                    System.out.println("Enter the task name you want to search: ");
                    String keyName = scanner.nextLine();

                    if (taskBook.containsKey(keyName)) {
                        System.out.println(taskBook.get(keyName));
                    } else {
                        System.out.println("Couldn't find the task with that name");
                    }

                } else if (userAction.equals("4")) {
                    System.out.println("Enter the task name you want to update: ");
                    String keyName = scanner.nextLine();
                    if (taskBook.containsKey(keyName)) {

                        System.out.println("Enter new task description: ");
                        String description = scanner.nextLine();
                        System.out.println("Enter new task priority: ");
                        int priority = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new task status: ");
                        String status = scanner.nextLine();

                        taskBook.get(keyName).setDescription(description);
                        taskBook.get(keyName).setPriority(priority);
                        taskBook.get(keyName).setStatus(status);
                        System.out.println("Task updated successfully!");
                    } else {
                        System.out.println("Couldn't find the task with that name");
                        continue;
                    }
                } else if (userAction.equals("5")) {
                    System.out.println("Enter the task name you want to delete: ");
                    String keyName = scanner.nextLine();
                    if (taskBook.containsKey(keyName)) {
                        taskBook.remove(keyName);
                        System.out.println("Task deleted successfully!");
                    }  else {
                        System.out.println("Couldn't find the task with that name");
                        continue;
                    }
                } else if (userAction.equals("6")) {
                    TreeMap<String, Task> taskSort = new TreeMap<>(taskBook);
                    System.out.println("Task sorted by name in ascending order");
                    for (Object keyName : taskSort.keySet()) {
                        System.out.println(taskSort.get(keyName));
                    }
                } else if (userAction.equals("7")) {
                    try (FileWriter fileWriter = new FileWriter("taskBook.txt");
                         PrintWriter writer = new PrintWriter(fileWriter);) {
                        for (String keyName : taskBook.keySet()) {
                            writer.println("Name: " + taskBook.get(keyName));
                        }
                    } catch (IOException e) {
                        System.out.println("Error writing to file " + e.getMessage());
                    }
                } else {
                    break;
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
    }
}
