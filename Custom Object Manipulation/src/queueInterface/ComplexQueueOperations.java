package queueInterface;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*The ComplexQueueOperations class provides methods to perform more advanced queue operations, such as moving tasks based on a priority threshold and merging two priority queues into one.*/
public class ComplexQueueOperations {
/*This method effectively moves all tasks from the sourceQueue to the destinationQueue if their priority is less than or equal to the priorityThreshold.
 *  Tasks with a priority higher than the threshold are moved back to the sourceQueue.*/
    public void moveTasksByPriority(Queue<Task> sourceQueue, Queue<Task> destinationQueue, int priorityThreshold) {
        int originalSize = sourceQueue.size();
        for (int i = 0; i < originalSize; i++) {
            Task task = sourceQueue.poll();
            if (task.getPriority() <= priorityThreshold) {
                destinationQueue.offer(task);
            } else {     
                sourceQueue.offer(task);
            }
            }
            }
    /*The mergePriorityQueues() method assumes that the Task class has a getPriority() method that returns the priority of the task as an integer. 
     * The Comparator used in the mergedQueue compares tasks based on their priority, ensuring that the merged queue maintains the priority order*/
    public Queue<Task> mergePriorityQueues(Queue<Task> pq1, Queue<Task> pq2) {
        Queue<Task> mergedQueue = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));
        mergedQueue.addAll(pq1);
        mergedQueue.addAll(pq2);
        return mergedQueue;
    }
}
