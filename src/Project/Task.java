package Project;

import java.time.LocalDate;

public class Task {
    private static int idCounter = 1;

    private final int id;
    private String title;
    private Priority priority;
    private Status status;
    private LocalDate dueDate;

    public Task(String title, Priority priority, LocalDate dueDate) {
        this.id       = idCounter++;
        this.title    = title;
        this.priority = priority;
        this.status   = Status.TODO;
        this.dueDate  = dueDate;
    }

    //  Getters
    public int       getId()       { return id; }
    public String    getTitle()    { return title; }
    public Priority  getPriority() { return priority; }
    public Status    getStatus()   { return status; }
    public LocalDate getDueDate()  { return dueDate; }

    //  Setters
    public void setTitle(String title)       { this.title    = title; }
    public void setPriority(Priority p)      { this.priority = p; }
    public void setStatus(Status s)          { this.status   = s; }
    public void setDueDate(LocalDate d)      { this.dueDate  = d; }

    @Override
    public String toString() {
        return String.format("[%d] %-25s | %-6s | %-11s | Due: %s",
                id, title, priority, status, dueDate != null ? dueDate : "N/A");
    }
}