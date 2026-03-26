package com.stayhard.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LevelServiceTest {

    private final LevelService levelService = new LevelService();

    @ParameterizedTest
    @DisplayName("Deve retornar nível correto baseado nos dias completos")
    @CsvSource({
            "0, Awakening",
            "3, Awakening",
            "6, Awakening",
            "7, Forged",
            "10, Forged",
            "14, Forged",
            "15, Relentless",
            "20, Relentless",
            "29, Relentless",
            "30, Unbreakable",
            "50, Unbreakable",
            "74, Unbreakable",
            "75, Stay Hard",
            "100, Stay Hard",
            "365, Stay Hard"
    })
    void shouldReturnCorrectLevel(int daysCompleted, String expectedLevel) {
        assertEquals(expectedLevel, levelService.getLevelName(daysCompleted));
    }

    @Test
    @DisplayName("Deve retornar Awakening para zero dias")
    void shouldReturnAwakeningForZeroDays() {
        assertEquals("Awakening", levelService.getLevelName(0));
    }

    @Test
    @DisplayName("Deve retornar Stay Hard para muitos dias")
    void shouldReturnStayHardForManyDays() {
        assertEquals("Stay Hard", levelService.getLevelName(1000));
    }
}
