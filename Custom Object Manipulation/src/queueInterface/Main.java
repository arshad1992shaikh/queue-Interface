package queueInterface;

import java.util.*;

public class Main {
	/*The Main class serves as the entry point of the program and demonstrates the usage of all the other classes and their methods.
	 *  It creates queues, adds tasks to them, performs various queue operations, analyzes performance, and showcases complex queue operations.*/
    public static void main(String[] args)  {
    	
        QueueOperation queueOperation = new QueueOperation();
        ComplexQueueOperations complexQueueOperations = new ComplexQueueOperations();
        QueuePerformanceAnalysis performanceAnalysis = new QueuePerformanceAnalysis();
        TaskScheduler scheduler = new TaskScheduler();

       
        Queue<Task> linkedListQueue = new LinkedList<>();
        Queue<Task> priorityQueue = new PriorityQueue<>();
        Queue<Task> arrayDequeQueue = new ArrayDeque<>();

        System.out.println("Adding tasks to LinkedList Queue...");
        queueOperation.addTaskToQueue(linkedListQueue, new Task(1, "Task 1", 3));
        queueOperation.addTaskToQueue(linkedListQueue, new Task(2, "Task 2", 1));
        queueOperation.addTaskToQueue(linkedListQueue, new Task(3, "Task 3", 2));
        queueOperation.addTaskToQueue(linkedListQueue, new Task(4, "Task 4", 3));
        queueOperation.addTaskToQueue(linkedListQueue, new Task(5, "Task 5", 1)); 

        System.out.println("Adding tasks to PriorityQueue...");
        queueOperation.addTaskToQueue(priorityQueue, new Task(6, "Task 6", 2));
        queueOperation.addTaskToQueue(priorityQueue, new Task(7, "Task 7", 1));
        queueOperation.addTaskToQueue(priorityQueue, new Task(8, "Task 8", 3));
        queueOperation.addTaskToQueue(priorityQueue, new Task(9, "Task 9", 4));

        System.out.println("Adding tasks to ArrayDeque Queue...");
        queueOperation.addTaskToQueue(arrayDequeQueue, new Task(10, "Task 10", 3));
        queueOperation.addTaskToQueue(arrayDequeQueue, new Task(11, "Task 11", 1));
        queueOperation.addTaskToQueue(arrayDequeQueue, new Task(12, "Task 12", 2));
        queueOperation.addTaskToQueue(arrayDequeQueue, new Task(13, "Task 13", 1));

        
        System.out.println("\n----- LinkedList Queue Operations -----");
        queueOperation.performQueueOperations(linkedListQueue);

        System.out.println("\n----- Priority Queue Operations -----");
        queueOperation.performQueueOperations(priorityQueue);

        System.out.println("\n----- ArrayDeque Queue Operations -----");
        queueOperation.performQueueOperations(arrayDequeQueue);

        
        System.out.println("\n----- Adding Tasks to Scheduler -----");
        scheduler.addTask(new Task(1, "Write a report", 2));
        scheduler.addTask(new Task(2, "Prepare presentation", 1));
        scheduler.addTask(new Task(3, "Send emails", 3));
        scheduler.addTask(new Task(4, "Schedule meeting", 1));

        System.out.println("\n----- Viewing and Completing Tasks in Scheduler -----");
        scheduler.viewPendingTasks();

        scheduler.completeTask(2);
        scheduler.completeTask(5); 

        System.out.println("\nAfter completing tasks:");
        scheduler.viewPendingTasks();

        scheduler.findTasksByPriorityRange(1, 2);

        
        int numElements = 1_000_000;

        System.out.println("\n----- Measure Enqueue Performance -----");
        performanceAnalysis.measureEnqueuePerformance(linkedListQueue, numElements, "LinkedList");
        performanceAnalysis.measureEnqueuePerformance(priorityQueue, numElements, "PriorityQueue");
        performanceAnalysis.measureEnqueuePerformance(arrayDequeQueue, numElements, "ArrayDeque");

        System.out.println("\n----- Measure Dequeue Performance -----");
        performanceAnalysis.measureDequeuePerformance(linkedListQueue, numElements, "LinkedList");
        performanceAnalysis.measureDequeuePerformance(priorityQueue, numElements, "PriorityQueue");
        performanceAnalysis.measureDequeuePerformance(arrayDequeQueue, numElements, "ArrayDeque");

        System.out.println("\n----- Measure Peek Performance -----");
        performanceAnalysis.measurePeekPerformance(linkedListQueue, numElements, "LinkedList");
        performanceAnalysis.measurePeekPerformance(priorityQueue, numElements, "PriorityQueue");
        performanceAnalysis.measurePeekPerformance(arrayDequeQueue, numElements, "ArrayDeque");
        
        
     
        linkedListQueue.offer(new Task(1, "Task 1", 3));
        linkedListQueue.offer(new Task(2, "Task 2", 1));
        linkedListQueue.offer(new Task(3, "Task 3", 2));
        linkedListQueue.offer(new Task(4, "Task 4", 3));
        linkedListQueue.offer(new Task(5, "Task 5", 1));

       
        arrayDequeQueue.offer(new Task(6, "Task 6", 2));
        arrayDequeQueue.offer(new Task(7, "Task 7", 1));
        arrayDequeQueue.offer(new Task(8, "Task 8", 3));
        arrayDequeQueue.offer(new Task(9, "Task 9", 4));

       
        priorityQueue.offer(new Task(10, "Task 10", 3));
        priorityQueue.offer(new Task(11, "Task 11", 1));
        priorityQueue.offer(new Task(12, "Task 12", 2));
        priorityQueue.offer(new Task(13, "Task 13", 1));

       
        System.out.println("\n----- Sort LinkedList by Priority -----");
        List<Task> sortedLinkedList = new ArrayList<>(linkedListQueue);
        Collections.sort(sortedLinkedList, Comparator.comparingInt(Task::getPriority));
        System.out.println(sortedLinkedList);

        System.out.println("\n----- Move Tasks from ArrayDeque to PriorityQueue -----");
        int priorityThreshold = 2;
        Queue<Task> movedTasks = new LinkedList<>();
        complexQueueOperations.moveTasksByPriority(arrayDequeQueue, movedTasks, priorityThreshold);
        System.out.println("ArrayDeque: " + arrayDequeQueue);
        System.out.println("Moved Tasks: " + movedTasks);

        System.out.println("\n----- Merge Two PriorityQueues -----");
        Queue<Task> pq1 = new PriorityQueue<>();
        pq1.add(new Task(14, "Task 14", 2));
        pq1.add(new Task(15, "Task 15", 1));
        Queue<Task> pq2 = new PriorityQueue<>();
        pq2.add(new Task(16, "Task 16", 3));
        pq2.add(new Task(17, "Task 17", 1));
        Queue<Task> mergedQueue = complexQueueOperations.mergePriorityQueues(pq1, pq2);
        System.out.println("Merged Queue: " + mergedQueue);

    }
    
}
