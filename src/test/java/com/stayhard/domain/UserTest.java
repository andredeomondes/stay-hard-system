package com.stayhard.domain;

import com.stayhard.domain.entities.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Deve criar novo usuário com valores zerados")
    void shouldCreateNewUserWithZeroValues() {
        User user = new User("André");

        assertEquals("André", user.getName());
        assertEquals(0, user.getDaysCompleted());
        assertEquals(0, user.getDaysFailed());
        assertEquals(0, user.getCurrentStreak());
        assertEquals(0, user.getMaxStreak());
    }

    @Test
    @DisplayName("Deve criar usuário restaurado com valores salvos")
    void shouldCreateRestoredUserWithSavedValues() {
        User user = new User("André", 10, 3, 5, 8);

        assertEquals("André", user.getName());
        assertEquals(10, user.getDaysCompleted());
        assertEquals(3, user.getDaysFailed());
        assertEquals(5, user.getCurrentStreak());
        assertEquals(8, user.getMaxStreak());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar usuário com nome nulo")
    void shouldThrowExceptionForNullName() {
        assertThrows(IllegalArgumentException.class, () -> new User(null));
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar usuário com nome vazio")
    void shouldThrowExceptionForBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new User("  "));
    }

    @Test
    @DisplayName("Deve incrementar dias completos e streak ao registrar dia completo")
    void shouldIncrementCompletedDaysAndStreak() {
        User user = new User("André");

        user.addCompletedDay();

        assertEquals(1, user.getDaysCompleted());
        assertEquals(1, user.getCurrentStreak());
        assertEquals(1, user.getMaxStreak());
    }

    @Test
    @DisplayName("Deve atualizar max streak quando streak atual ultrapassa")
    void shouldUpdateMaxStreakWhenCurrentExceeds() {
        User user = new User("André", 5, 0, 5, 5);

        user.addCompletedDay();

        assertEquals(6, user.getCurrentStreak());
        assertEquals(6, user.getMaxStreak());
    }

    @Test
    @DisplayName("Não deve alterar max streak quando streak atual é menor")
    void shouldNotUpdateMaxStreakWhenCurrentIsLower() {
        User user = new User("André", 5, 1, 0, 5);

        user.addCompletedDay();

        assertEquals(1, user.getCurrentStreak());
        assertEquals(5, user.getMaxStreak());
    }

    @Test
    @DisplayName("Deve resetar streak e incrementar dias falhos ao registrar dia falho")
    void shouldResetStreakAndIncrementFailedDays() {
        User user = new User("André", 5, 0, 5, 5);

        user.addFailedDay();

        assertEquals(1, user.getDaysFailed());
        assertEquals(0, user.getCurrentStreak());
        assertEquals(5, user.getMaxStreak());
    }
}
