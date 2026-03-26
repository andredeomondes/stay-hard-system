package com.stayhard.domain.utils;

import java.util.Scanner;

public class ConsoleVisual {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    private static final String LINHA = "--------------------------------------------";

    public static void printHeader(String title) {
        clearCanvas();
        System.out.println(RED + BOLD + LINHA + RESET);
        int padding = (44 - title.length()) / 2;
        System.out.printf(RED + BOLD + "%" + (padding + title.length()) + "s%n" + RESET, title.toUpperCase());
        System.out.println(RED + BOLD + LINHA + RESET);
    }

    public static void clearCanvas() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void success(String msg) {
        System.out.println(GREEN + "[✔] SUCCESS: " + RESET + msg);
    }

    public static void error(String msg) {
        System.out.println(RED + BOLD + "[✘] ERROR: " + RESET + msg);
    }

    public static void alert(String msg) {
        System.out.println(YELLOW + "[!] ALERT: " + RESET + msg);
    }

    public static void info(String msg) {
        System.out.println(BLUE + "[i] INFO: " + RESET + msg);
    }

    public static String input(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(CYAN + BOLD + "> " + prompt + ": " + RESET);
        return sc.nextLine();
    }

    public static void divider() {
        System.out.println(RED + "............................................" + RESET);
    }
}
