package com.stayhard.domain;

import com.stayhard.domain.entities.Habit;
import com.stayhard.domain.enums.Priority;
import com.stayhard.domain.enums.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HabitTest {

    @Test
    @DisplayName("Deve criar hábito com status TODO")
    void shouldCreateHabitWithTodoStatus() {
        Habit habit = new Habit("Treinar", Priority.HIGH);

        assertEquals("Treinar", habit.getName());
        assertEquals(Priority.HIGH, habit.getPriority());
        assertEquals(Status.TODO, habit.getStatus());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar hábito com nome nulo")
    void shouldThrowExceptionForNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Habit(null, Priority.HIGH));
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar hábito com nome vazio")
    void shouldThrowExceptionForBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Habit("  ", Priority.LOW));
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar hábito com prioridade nula")
    void shouldThrowExceptionForNullPriority() {
        assertThrows(IllegalArgumentException.class, () -> new Habit("Treinar", null));
    }

    @Test
    @DisplayName("Deve iniciar hábito de TODO para IN_PROGRESS")
    void shouldStartHabitFromTodoToInProgress() {
        Habit habit = new Habit("Treinar", Priority.HIGH);

        habit.start();

        assertEquals(Status.IN_PROGRESS, habit.getStatus());
    }

    @Test
    @DisplayName("Não deve iniciar hábito que não está em TODO")
    void shouldNotStartHabitThatIsNotTodo() {
        Habit habit = new Habit("Treinar", Priority.HIGH);
        habit.start();

        habit.start();

        assertEquals(Status.IN_PROGRESS, habit.getStatus());
    }

    @Test
    @DisplayName("Deve completar hábito")
    void shouldCompleteHabit() {
        Habit habit = new Habit("Treinar", Priority.HIGH);
        habit.start();

        habit.complete();

        assertEquals(Status.DONE, habit.getStatus());
    }

    @Test
    @DisplayName("Deve resetar hábito para TODO")
    void shouldResetHabitToTodo() {
        Habit habit = new Habit("Treinar", Priority.HIGH);
        habit.complete();

        habit.reset();

        assertEquals(Status.TODO, habit.getStatus());
    }

    @Test
    @DisplayName("Deve restaurar status corretamente")
    void shouldRestoreStatus() {
        Habit habit = new Habit("Treinar", Priority.HIGH);

        habit.restoreStatus(Status.DONE);

        assertEquals(Status.DONE, habit.getStatus());
    }

    @Test
    @DisplayName("Deve lançar exceção ao restaurar status nulo")
    void shouldThrowExceptionForNullStatus() {
        Habit habit = new Habit("Treinar", Priority.HIGH);

        assertThrows(IllegalArgumentException.class, () -> habit.restoreStatus(null));
    }
}
