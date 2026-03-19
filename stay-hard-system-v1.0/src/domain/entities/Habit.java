package domain.entities;

import domain.enums.Priority;
import domain.enums.Status;

public class Habit {
    private String name;
    private Priority priority;
    private Status status;

    public Habit() {
    }

    public Habit(String name, Priority priority, Status status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
