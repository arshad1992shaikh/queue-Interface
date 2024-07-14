package queueInterface;

import java.util.*;

public class TaskScheduler {
	
    private Queue<Task> pendingTasks;
    private Queue<Task> completedTasks;

    public TaskScheduler() {
        pendingTasks = new PriorityQueue<>(); 
        completedTasks = new LinkedList<>();
    }
/*addTask(Task task): This method adds a new task to the pendingTasks queue. It prints a message indicating that the task has been added.*/
    public void addTask(Task task) {
        pendingTasks.add(task);
        System.out.println("Task added: " + task);
    }
/*completeTask(int taskId): This method marks a task as completed by removing it from the pendingTasks queue and adding it to the completedTasks queue. 
 * It prints a message indicating that the task has been marked as completed. If the task is not found in the pendingTasks queue, it prints a message indicating that the task was not found.*/
    public void completeTask(int taskId) {
        Iterator<Task> iterator = pendingTasks.iterator();
        while (iterator.hasNext()) {
          Task task = iterator.next();
          if (task.getId() == taskId) {
          completedTasks.add(task);
          iterator.remove();
          System.out.println("Task " + taskId + " marked as completed.");
          return;
          }
          }
        System.out.println("Task " + taskId + " not found.");
         }
/*viewPendingTasks(): This method prints all the pending tasks in the pendingTasks queue, ordered by priority. If the queue is empty, it prints a message indicating that there are no pending tasks*/
    public void viewPendingTasks() {
        System.out.println("Pending Tasks (ordered by priority):");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            for (Task task : pendingTasks) {
                System.out.println(task);
            }
            }
            }
/*findTasksByPriorityRange(int minPriority, int maxPriority): This method prints all the pending tasks in the pendingTasks queue that have a priority within the given range (inclusive). 
 * If the queue is empty, it prints a message indicating that there are no pending tasks*/
    public void findTasksByPriorityRange(int minPriority, int maxPriority) {
        System.out.println("Tasks with priority between " + minPriority + " and " + maxPriority + ":");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            for (Task task : pendingTasks) {
                if (task.getPriority() >= minPriority && task.getPriority() <= maxPriority) {
                    System.out.println(task);
                }
                }
                }
                } }