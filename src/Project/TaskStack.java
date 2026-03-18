package Project;

import java.util.LinkedList;
import java.util.Deque;

public class TaskStack {
    private final Deque<Task> stack = new LinkedList<>();

    public void push(Task task) { stack.push(task); }

    public Task pop() {
        if (stack.isEmpty()) {
            System.out.println("  Nothing to undo.");
            return null;
        }
        return stack.pop();
    }

    public boolean isEmpty() { return stack.isEmpty(); }
}