package queueInterface;

import java.util.*;
/*The QueuePerformanceAnalysis class provides methods to measure the performance of enqueuing, dequeuing, and peeking at the head of a queue. 
 * These methods can be used to compare the performance of different queue implementations, such as LinkedList, PriorityQueue, and ArrayDeque.*/
public class QueuePerformanceAnalysis {
	/*measureEnqueuePerformance(Queue<Task> queue, int numElements, String queueType): This method takes a Queue<Task>, an integer numElements, and a string queueType as parameters.
	 *  It measures the performance of enqueuing tasks into the queue*/
    public void measureEnqueuePerformance(Queue<Task> queue, int numElements, String queueType) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            queue.offer(new Task(i, "Task " + i, i % 10));
        }
        long endTime = System.nanoTime();
        System.out.println("Enqueue time for " + queueType + ": " + (endTime - startTime) + " nanoseconds");
        }
  /*measureDequeuePerformance(Queue<Task> queue, int numElements, String queueType): This method is similar to the measureEnqueuePerformance() method, but it measures the performance of dequeueing tasks from the queue. 
  * It follows the same process as the measureEnqueuePerformance() method, but instead of adding tasks to the queue, it removes tasks from the queue using the poll() method.*/
    public void measureDequeuePerformance(Queue<Task> queue, int numElements, String queueType) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            queue.poll();
        }
        long endTime = System.nanoTime();
        System.out.println("Dequeue time for " + queueType + ": " + (endTime - startTime) + " nanoseconds");
        }
/*measurePeekPerformance(Queue<Task> queue, int numElements, String queueType): This method measures the performance of peeking at the head of the queue. It follows a similar process to the measureEnqueuePerformance() and measureDequeuePerformance() methods, 
 * but instead of adding or removing tasks, it simply peeks at the head of the queue using the peek() method.*/
    public void measurePeekPerformance(Queue<Task> queue, int numElements, String queueType) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            queue.peek();
        }
        long endTime = System.nanoTime();
        System.out.println("Peek time for " + queueType + ": " + (endTime - startTime) + " nanoseconds");
        }
}