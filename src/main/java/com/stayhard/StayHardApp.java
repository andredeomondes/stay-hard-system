package com.stayhard;

import com.stayhard.controller.HabitController;
import com.stayhard.controller.UserController;
import com.stayhard.repository.csv.CsvHabitRepository;
import com.stayhard.repository.csv.CsvUserRepository;
import com.stayhard.service.HabitService;
import com.stayhard.service.LevelService;
import com.stayhard.service.UserService;
import com.stayhard.ui.UserMenus;

public class StayHardApp {

    public static void main(String[] args) {
        CsvHabitRepository habitRepository = new CsvHabitRepository("data/habits.csv");
        CsvUserRepository userRepository = new CsvUserRepository("data/user.csv", "Player");

        HabitService habitService = new HabitService(habitRepository);
        UserService userService = new UserService(userRepository);
        LevelService levelService = new LevelService();

        HabitController habitController = new HabitController(habitService);
        UserController userController = new UserController(userService, levelService);

        UserMenus menu = new UserMenus(habitController, userController);
        menu.start();
    }
}
