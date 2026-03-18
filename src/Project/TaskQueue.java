package Project;

import java.util.PriorityQueue;
import java.util.Comparator;

public class TaskQueue {
    private final PriorityQueue<Task> queue;

    public TaskQueue() {
        // Sort by Priority ordinal
        queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.getPriority().ordinal()));
    }

    public void enqueue(Task task) { queue.offer(task); }

    public Task dequeue() {
        if (queue.isEmpty()) {
            System.out.println("  Queue is empty.");
            return null;
        }
        return queue.poll();
    }

    public Task peek() { return queue.peek(); }

    public boolean isEmpty() { return queue.isEmpty(); }

    public int size() { return queue.size(); }
}
