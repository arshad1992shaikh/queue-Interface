package queueInterface;

import java.util.*;
/*The QueueOperation class provides a set of methods to perform basic queue operations, such as adding tasks to the queue,
 *  dequeuing tasks, peeking at the head of the queue, and checking if a specific task exists in the queue.*/
public class QueueOperation{
	/*addTaskToQueue(Queue<Task> queue, Task task): This method takes a Queue<Task> and a Task object as parameters.
	 *  It adds the Task object to the queue using the offer() method and then prints a message indicating that the task has been added to the queue*/
    public void addTaskToQueue(Queue<Task> queue, Task task) {
        queue.offer(task);
        System.out.println("Added task to queue: " + task);
    }
    /*performQueueOperations(Queue<Task> queue): This method takes a Queue<Task> as a parameter */
    public void performQueueOperations(Queue<Task> queue) {
        /*Dequeue Tasks: The method enters a loop that continues as long as the queue is not empty.
         *  In each iteration of the loop, it removes the task at the front of the queue using the poll() method and prints a message indicating that the task has been dequeued.*/
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            System.out.println("Dequeued task: " + task);
        }
        /*Peek at the Head: After dequeuing all the tasks, the method checks if the queue is still not empty. 
         * If it is not empty, it prints the task at the head of the queue using the peek() method.*/
        if (!queue.isEmpty()) {
            Task task = queue.peek();
            System.out.println("Task at the head: " + task);
        }/*Check for a Specific Task: The method creates a new Task object with an id of 2, a description of "Task 2", and a priority of 1.
         It then checks if this task exists in the queue using the contains() method and prints a message indicating whether the task is present or not*/
        Task taskToCheck = new Task(2, "Task 2", 1);
        if (queue.contains(taskToCheck)) {
            System.out.println("Task " + taskToCheck + " exists in the queue.");
        } else {
            System.out.println("Task " + taskToCheck + " does not exist in the queue.");
        }
        }
}
