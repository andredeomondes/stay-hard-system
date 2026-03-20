package domain.utils;

import domain.entities.Habit;
import domain.entities.User;
import domain.enums.Priority;
import domain.utils.ConsoleVisual;
import service.HabitService;

import java.util.List;
import java.util.Scanner;

public class UserMenus {

    private final HabitService habitService;
    private final User user;
    private final Scanner scanner;

    public UserMenus() {
        this.habitService = new HabitService();
        this.user = new User("Player");
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;

        do {
            showMainMenu();
            option = readInt("Escolha uma opção");

            switch (option) {
                case 1 -> createHabit();
                case 2 -> listHabits();
                case 3 -> startHabit();
                case 4 -> completeHabit();
                case 5 -> showStatus();
                case 6 -> finishDay();
                case 0 -> ConsoleVisual.info("Saindo do sistema...");
                default -> ConsoleVisual.error("Opção inválida.");
            }

            if (option != 0) {
                pressEnterToContinue();
            }

        } while (option != 0);
    }

    private void showMainMenu() {
        ConsoleVisual.printHeader("Stay Hard System");
        System.out.println("1 - Criar hábito");
        System.out.println("2 - Listar hábitos");
        System.out.println("3 - Iniciar hábito");
        System.out.println("4 - Concluir hábito");
        System.out.println("5 - Ver status");
        System.out.println("6 - Finalizar dia");
        System.out.println("0 - Sair");
        ConsoleVisual.divider();
    }

    private void createHabit() {
        ConsoleVisual.printHeader("Criar Hábito");

        System.out.print(ConsoleVisual.CYAN + ConsoleVisual.BOLD + "> Nome do hábito: " + ConsoleVisual.RESET);
        String name = scanner.nextLine().trim();

        if (name.isBlank()) {
            ConsoleVisual.error("O nome do hábito não pode ser vazio.");
            return;
        }

        System.out.println("Prioridade:");
        System.out.println("1 - LOW");
        System.out.println("2 - MEDIUM");
        System.out.println("3 - HIGH");
        ConsoleVisual.divider();

        int option = readInt("Escolha a prioridade");

        Priority priority = switch (option) {
            case 1 -> Priority.LOW;
            case 2 -> Priority.MEDIUM;
            case 3 -> Priority.HIGH;
            default -> null;
        };

        if (priority == null) {
            ConsoleVisual.error("Prioridade inválida.");
            return;
        }

        habitService.addHabit(name, priority);
        ConsoleVisual.success("Hábito criado com sucesso.");
    }

    private void listHabits() {
        ConsoleVisual.printHeader("Lista de Hábitos");

        if (!habitService.hasHabits()) {
            ConsoleVisual.alert("Nenhum hábito cadastrado.");
            return;
        }

        List<Habit> habits = habitService.getAllHabits();

        for (int i = 0; i < habits.size(); i++) {
            Habit h = habits.get(i);

            System.out.printf(
                    "%d - %s [%s] [%s]%n",
                    i + 1,
                    h.getName(),
                    h.getPriority(),
                    h.getStatus()
            );
        }

        ConsoleVisual.divider();
        ConsoleVisual.info("Total de hábitos: " + habits.size());
    }

    private void startHabit() {
        if (!habitService.hasHabits()) {
            ConsoleVisual.alert("Nenhum hábito cadastrado.");
            return;
        }

        listHabits();
        int index = readInt("Escolha o número do hábito para iniciar") - 1;

        if (habitService.startHabit(index)) {
            ConsoleVisual.success("Hábito iniciado com sucesso.");
        } else {
            ConsoleVisual.error("Índice inválido.");
        }
    }

    private void completeHabit() {
        if (!habitService.hasHabits()) {
            ConsoleVisual.alert("Nenhum hábito cadastrado.");
            return;
        }

        listHabits();
        int index = readInt("Escolha o número do hábito para concluir") - 1;

        if (habitService.completeHabit(index)) {
            ConsoleVisual.success("Hábito concluído com sucesso.");
        } else {
            ConsoleVisual.error("Índice inválido.");
        }
    }

    private void finishDay() {
        ConsoleVisual.printHeader("Finalizar Dia");

        if (!habitService.hasHabits()) {
            ConsoleVisual.alert("Crie pelo menos um hábito antes de finalizar o dia.");
            return;
        }

        boolean success = habitService.allHighCompleted();

        if (success) {
            user.addCompletedDay();
            ConsoleVisual.success("DAY COMPLETE");
        } else {
            user.addFailedDay();
            ConsoleVisual.error("DAY FAILED");
        }

        habitService.resetHabits();
        ConsoleVisual.info("Todos os hábitos foram resetados para TODO.");
    }

    private void showStatus() {
        ConsoleVisual.printHeader("Status do Jogador");

        System.out.println("Nome: " + user.getName());
        System.out.println("Dias completos: " + user.getDaysCompleted());
        System.out.println("Dias falhos: " + user.getDaysFailed());
        System.out.println("Streak atual: " + user.getCurrentStreak());
        System.out.println("Maior streak: " + user.getMaxStreak());
        System.out.println("Level: " + getLevelName(user.getDaysCompleted()));

        ConsoleVisual.divider();

        if (habitService.hasHabits()) {
            System.out.println("Hábitos concluídos hoje: " + habitService.countCompletedHabits());
            System.out.println("Hábitos HIGH: " + habitService.countHabitsByPriority(Priority.HIGH));
            System.out.println("Hábitos MEDIUM: " + habitService.countHabitsByPriority(Priority.MEDIUM));
            System.out.println("Hábitos LOW: " + habitService.countHabitsByPriority(Priority.LOW));
        } else {
            ConsoleVisual.info("Nenhum hábito cadastrado ainda.");
        }
    }

    private String getLevelName(int daysCompleted) {
        if (daysCompleted >= 75) return "Stay Hard";
        if (daysCompleted >= 30) return "Unbreakable";
        if (daysCompleted >= 15) return "Relentless";
        if (daysCompleted >= 7) return "Forged";
        return "Awakening";
    }

    private int readInt(String message) {
        while (true) {
            try {
                System.out.print(ConsoleVisual.CYAN + ConsoleVisual.BOLD + "> " + message + ": " + ConsoleVisual.RESET);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                ConsoleVisual.error("Digite um número válido.");
            }
        }
    }

    private void pressEnterToContinue() {
        System.out.print(ConsoleVisual.YELLOW + "Pressione ENTER para continuar..." + ConsoleVisual.RESET);
        scanner.nextLine();
    }
}