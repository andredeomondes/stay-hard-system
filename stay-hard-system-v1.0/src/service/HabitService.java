package service;

import domain.entities.Habit;
import domain.enums.Priority;
import domain.enums.Status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HabitService {

    private final List<Habit> habits = new ArrayList<>();

    public void addHabit(String name, Priority priority) {
        Habit habit = new Habit(name, priority);
        habits.add(habit);
    }

    public List<Habit> getAllHabits() {
        return Collections.unmodifiableList(habits);
    }

    public boolean hasHabits() {
        return !habits.isEmpty();
    }

    public Habit findHabitByIndex(int index) {
        if (isInvalidIndex(index)) {
            return null;
        }
        return habits.get(index);
    }

    public boolean startHabit(int index) {
        if (isInvalidIndex(index)) {
            return false;
        }

        Habit habit = habits.get(index);
        habit.start();
        return true;
    }

    public boolean completeHabit(int index) {
        if (isInvalidIndex(index)) {
            return false;
        }

        Habit habit = habits.get(index);
        habit.complete();
        return true;
    }

    public void resetHabits() {
        for (Habit habit : habits) {
            habit.reset();
        }
    }

    public boolean allHighCompleted() {
        boolean hasHighPriorityHabit = false;

        for (Habit habit : habits) {
            if (habit.getPriority() == Priority.HIGH) {
                hasHighPriorityHabit = true;

                if (habit.getStatus() != Status.DONE) {
                    return false;
                }
            }
        }

        return hasHighPriorityHabit;
    }

    public long countHabitsByPriority(Priority priority) {
        return habits.stream()
                .filter(habit -> habit.getPriority() == priority)
                .count();
    }

    public long countCompletedHabits() {
        return habits.stream()
                .filter(habit -> habit.getStatus() == Status.DONE)
                .count();
    }

    public boolean isInvalidIndex(int index) {
        return index < 0 || index >= habits.size();
    }

}