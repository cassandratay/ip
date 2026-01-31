package theo.task;

import java.util.ArrayList;

/**
 * Represents the task list. Contains information of all tasks.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Creates an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Constructs a task list with an existing list of tasks.
     *
     * @param tasks An ArrayList of Task objects to initialize the list with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the task list.
     *
     * @param task Task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the task list at the specified index.
     *
     * @param index Index of the task to remove.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    /**
     * Returns the number of tasks currently in the list.
     *
     * @return The number of tasks.
     */
    public int numOfTasks() {
        return tasks.size();
    }

    /**
     * Retrieves the task at the specified index.
     *
     * @param index The index of the task to retrieve.
     * @return The Task at the given index.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Task task : tasks) {
            output.append(task.formatString()).append("\n");
        }
        return output.toString();
    }

}
