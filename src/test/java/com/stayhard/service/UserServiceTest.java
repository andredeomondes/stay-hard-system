package com.stayhard.service;

import com.stayhard.domain.entities.User;
import com.stayhard.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private InMemoryUserRepository repository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        repository = new InMemoryUserRepository();
        userService = new UserService(repository);
    }

    @Test
    @DisplayName("Deve carregar usuário do repositório")
    void shouldLoadUserFromRepository() {
        User user = userService.getUser();

        assertNotNull(user);
        assertEquals("Player", user.getName());
    }

    @Test
    @DisplayName("Deve registrar dia completo e persistir")
    void shouldRegisterCompletedDayAndPersist() {
        userService.registerCompletedDay();

        User user = userService.getUser();
        assertEquals(1, user.getDaysCompleted());
        assertEquals(1, user.getCurrentStreak());

        User savedUser = repository.load();
        assertEquals(1, savedUser.getDaysCompleted());
    }

    @Test
    @DisplayName("Deve registrar dia falho e persistir")
    void shouldRegisterFailedDayAndPersist() {
        userService.registerCompletedDay();
        userService.registerFailedDay();

        User user = userService.getUser();
        assertEquals(1, user.getDaysFailed());
        assertEquals(0, user.getCurrentStreak());

        User savedUser = repository.load();
        assertEquals(1, savedUser.getDaysFailed());
    }

    static class InMemoryUserRepository implements UserRepository {
        private User user = new User("Player");

        @Override
        public User load() {
            return new User(user.getName(), user.getDaysCompleted(),
                    user.getDaysFailed(), user.getCurrentStreak(), user.getMaxStreak());
        }

        @Override
        public void save(User user) {
            this.user = user;
        }
    }
}
