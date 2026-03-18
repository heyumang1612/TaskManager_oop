package Project;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private final Map<Integer, Task> taskMap  = new LinkedHashMap<>();
    private final TaskStack          undoStack = new TaskStack();
    private final TaskQueue          priorityQueue = new TaskQueue();

    // ── Add ───────────────────────────────────────────────────
    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
        priorityQueue.enqueue(task);
        undoStack.push(task);
        System.out.println("    Added: " + task);
    }

    // ── Remove ────────────────────────────────────────────────
    public void removeTask(int id) {
        Task removed = taskMap.remove(id);
        if (removed != null)
            System.out.println("   Removed: " + removed);
        else
            System.out.println("  X Task #" + id + " not found.");
    }

    // ── Update Status ─────────────────────────────────────────
    public void updateStatus(int id, Status newStatus) {
        Task task = taskMap.get(id);
        if (task == null) { System.out.println("  X Not found."); return; }
        task.setStatus(newStatus);
        System.out.println("    Status updated  -> " + task);
    }

    // ── Undo Last Add ─────────────────────────────────────────
    public void undoLastAdd() {
        Task last = undoStack.pop();
        if (last != null) {
            taskMap.remove(last.getId());
            System.out.println("    Undone: " + last);
        }
    }

    //  Get Next by Priority
    public void processNext() {
        Task next = priorityQueue.dequeue();
        if (next != null) System.out.println("    Next task: " + next);
    }

    //  Filter
    public List<Task> filterByStatus(Status status) {
        return taskMap.values().stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<Task> filterByPriority(Priority priority) {
        return taskMap.values().stream()
                .filter(t -> t.getPriority() == priority)
                .collect(Collectors.toList());
    }

    //  Display All
    public void displayAll() {
        if (taskMap.isEmpty()) { System.out.println("  No tasks."); return; }
        System.out.println("\n---All Tasks----------------------------------- ");
        taskMap.values().forEach(t -> System.out.println("  |  " + t));
        System.out.println("-------------------------------------------------- ");
    }

    //  Summary
    public void displaySummary() {
        long todo  = taskMap.values().stream().filter(t -> t.getStatus() == Status.TODO).count();
        long inProg = taskMap.values().stream().filter(t -> t.getStatus() == Status.IN_PROGRESS).count();
        long done  = taskMap.values().stream().filter(t -> t.getStatus() == Status.DONE).count();
        System.out.printf("%n  Summary → Total: %d | TODO: %d | IN_PROGRESS: %d | DONE: %d%n",
                taskMap.size(), todo, inProg, done);
    }
}
