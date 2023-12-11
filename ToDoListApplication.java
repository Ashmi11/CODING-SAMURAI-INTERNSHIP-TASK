import java.util.ArrayList;
import java.util.Scanner;

// Task class to represent individual tasks
class Task {
    String title;
    String description;
    String dueDate;
    boolean isComplete;

    // Constructor to initialize task properties
    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false; // Default: task is incomplete
    }
}

// Main class for the To-Do List Application
public class ToDoListApplication {
    private static ArrayList<Task> taskList = new ArrayList<>(); // List to store tasks
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu(); // Display the main menu
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(); // Call method to add a new task
                    break;
                case 2:
                    markTaskAsComplete(); // Call method to mark a task as complete
                    break;
                case 3:
                    viewTasks(); // Call method to view all tasks
                    break;
                case 4:
                    removeTask(); // Call method to remove a task
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5); // Continue the loop until the user chooses to exit
    }

    // Method to display the main menu
    private static void displayMenu() {
        System.out.println("\n----- To-Do List Application -----");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Tasks");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
    }

    // Method to add a new task to the taskList
    private static void addTask() {
        System.out.println("\n----- Add Task -----");
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        // Create a new Task object and add it to the taskList
        Task newTask = new Task(title, description, dueDate);
        taskList.add(newTask);

        System.out.println("Task added successfully!");
    }

    // Method to mark a task as complete
    private static void markTaskAsComplete() {
        System.out.println("\n----- Mark Task as Complete -----");
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty. No tasks to mark as complete.");
            return;
        }

        viewTasks(); // Display the list of tasks
        System.out.print("Enter the index of the task to mark as complete: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < taskList.size()) {
            Task task = taskList.get(index);
            task.isComplete = true;
            System.out.println("Task marked as complete: " + task.title);
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    // Method to view all tasks in the taskList
    private static void viewTasks() {
        System.out.println("\n----- View Tasks -----");
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                System.out.println("Index: " + i);
                System.out.println("Title: " + task.title);
                System.out.println("Description: " + task.description);
                System.out.println("Due Date: " + task.dueDate);
                System.out.println("Status: " + (task.isComplete ? "Complete" : "Incomplete"));
                System.out.println("----------------------------");
            }
        }
    }

    // Method to remove a task from the taskList
    private static void removeTask() {
        System.out.println("\n----- Remove Task -----");
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty. No tasks to remove.");
            return;
        }

        viewTasks(); // Display the list of tasks
        System.out.print("Enter the index of the task to remove: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < taskList.size()) {
            Task removedTask = taskList.remove(index);
            System.out.println("Task removed: " + removedTask.title);
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }
}
