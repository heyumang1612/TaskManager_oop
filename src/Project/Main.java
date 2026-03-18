package Project;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        System.out.println("\n----------TASK MANAGER DEMO----------\n");

        //  Add Tasks
        manager.addTask(new Task("Design database schema",   Priority.HIGH,   LocalDate.of(2025, 3, 20)));
        manager.addTask(new Task("Write unit tests",         Priority.MEDIUM, LocalDate.of(2025, 3, 25)));
        manager.addTask(new Task("Update README docs",       Priority.LOW,    LocalDate.of(2025, 4, 1)));
        manager.addTask(new Task("Fix login bug",            Priority.HIGH,   LocalDate.of(2025, 3, 18)));
        manager.addTask(new Task("Deploy to staging server", Priority.MEDIUM, null));

        //  Display All
        manager.displayAll();
        manager.displaySummary();

        //   Update Status
        System.out.println("\n--- Updating statuses -----");
        manager.updateStatus(1, Status.IN_PROGRESS);
        manager.updateStatus(4, Status.DONE);

        //   Filter by Status
        System.out.println("\n--- TODO tasks ----");
        manager.filterByStatus(Status.TODO).forEach(t -> System.out.println("  " + t));

        System.out.println("\n---- HIGH priority tasks----");
        manager.filterByPriority(Priority.HIGH).forEach(t -> System.out.println("  " + t));

        //  Priority Queue: process next
        System.out.println("\n---- Next highest-priority task ----");
        manager.processNext();

        //   Undo last added task
        System.out.println("\n--- Undo last added task---");
        manager.undoLastAdd();

        //   Remove a task
        System.out.println("\n--- Remove task #2 ---");
        manager.removeTask(2);

        //   Final State
        manager.displayAll();
        manager.displaySummary();
    }
}
