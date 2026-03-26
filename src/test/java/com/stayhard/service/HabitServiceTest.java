package com.stayhard.service;

import com.stayhard.domain.entities.Habit;
import com.stayhard.domain.enums.Priority;
import com.stayhard.domain.enums.Status;
import com.stayhard.repository.HabitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HabitServiceTest {

    private InMemoryHabitRepository repository;
    private HabitService habitService;

    @BeforeEach
    void setUp() {
        repository = new InMemoryHabitRepository();
        habitService = new HabitService(repository);
    }

    @Test
    @DisplayName("Deve adicionar hábito corretamente")
    void shouldAddHabit() {
        habitService.addHabit("Treinar", Priority.HIGH);

        List<Habit> habits = habitService.getAllHabits();
        assertEquals(1, habits.size());
        assertEquals("Treinar", habits.get(0).getName());
        assertEquals(Priority.HIGH, habits.get(0).getPriority());
    }

    @Test
    @DisplayName("Deve verificar se tem hábitos")
    void shouldCheckHasHabits() {
        assertFalse(habitService.hasHabits());

        habitService.addHabit("Treinar", Priority.HIGH);

        assertTrue(habitService.hasHabits());
    }

    @Test
    @DisplayName("Deve iniciar hábito por índice válido")
    void shouldStartHabitByValidIndex() {
        habitService.addHabit("Treinar", Priority.HIGH);

        assertTrue(habitService.startHabit(0));
        assertEquals(Status.IN_PROGRESS, habitService.getAllHabits().get(0).getStatus());
    }

    @Test
    @DisplayName("Deve retornar false ao iniciar com índice inválido")
    void shouldReturnFalseForInvalidIndex() {
        habitService.addHabit("Treinar", Priority.HIGH);

        assertFalse(habitService.startHabit(-1));
        assertFalse(habitService.startHabit(5));
    }

    @Test
    @DisplayName("Deve completar hábito por índice válido")
    void shouldCompleteHabitByValidIndex() {
        habitService.addHabit("Treinar", Priority.HIGH);

        assertTrue(habitService.completeHabit(0));
        assertEquals(Status.DONE, habitService.getAllHabits().get(0).getStatus());
    }

    @Test
    @DisplayName("Deve resetar todos os hábitos")
    void shouldResetAllHabits() {
        habitService.addHabit("Treinar", Priority.HIGH);
        habitService.addHabit("Ler", Priority.MEDIUM);
        habitService.completeHabit(0);
        habitService.completeHabit(1);

        habitService.resetHabits();

        for (Habit habit : habitService.getAllHabits()) {
            assertEquals(Status.TODO, habit.getStatus());
        }
    }

    @Test
    @DisplayName("Deve retornar true quando todos HIGH estão completos")
    void shouldReturnTrueWhenAllHighCompleted() {
        habitService.addHabit("Treinar", Priority.HIGH);
        habitService.addHabit("Ler", Priority.MEDIUM);
        habitService.completeHabit(0);

        assertTrue(habitService.allHighCompleted());
    }

    @Test
    @DisplayName("Deve retornar false quando algum HIGH não está completo")
    void shouldReturnFalseWhenSomeHighNotCompleted() {
        habitService.addHabit("Treinar", Priority.HIGH);
        habitService.addHabit("Ler", Priority.HIGH);

        assertFalse(habitService.allHighCompleted());
    }

    @Test
    @DisplayName("Deve retornar false quando não há hábitos HIGH")
    void shouldReturnFalseWhenNoHighHabits() {
        habitService.addHabit("Ler", Priority.MEDIUM);
        habitService.addHabit("Caminhar", Priority.LOW);

        assertFalse(habitService.allHighCompleted());
    }

    @Test
    @DisplayName("Deve contar hábitos por prioridade")
    void shouldCountHabitsByPriority() {
        habitService.addHabit("Treinar", Priority.HIGH);
        habitService.addHabit("Ler", Priority.HIGH);
        habitService.addHabit("Caminhar", Priority.LOW);

        assertEquals(2, habitService.countHabitsByPriority(Priority.HIGH));
        assertEquals(0, habitService.countHabitsByPriority(Priority.MEDIUM));
        assertEquals(1, habitService.countHabitsByPriority(Priority.LOW));
    }

    @Test
    @DisplayName("Deve contar hábitos completos")
    void shouldCountCompletedHabits() {
        habitService.addHabit("Treinar", Priority.HIGH);
        habitService.addHabit("Ler", Priority.MEDIUM);
        habitService.completeHabit(0);

        assertEquals(1, habitService.countCompletedHabits());
    }

    // TODO: Testes para updateHabit() e deleteHabit() — fazer no Dia 3 da Fase 0

    static class InMemoryHabitRepository implements HabitRepository {
        private final List<Habit> habits = new ArrayList<>();

        @Override
        public List<Habit> load() {
            return new ArrayList<>(habits);
        }

        @Override
        public void save(List<Habit> habits) {
            this.habits.clear();
            this.habits.addAll(habits);
        }
    }
}
