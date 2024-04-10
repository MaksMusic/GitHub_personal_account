package ru.maksmusic.view;

import ru.maksmusic.service.UserService;

import java.util.Scanner;

/**
 * Menu: класс для управления пользовательским интерфейсом и взаимодействия с
 */
public class Menu {
    UserService userService = new UserService();
    private Scanner scanner = new Scanner(System.in);
    public void start(){
        System.out.println("1 registration user");
        System.out.println("2 registration admin");
        System.out.println("3 registration superAdmin");
        System.out.println("4 LogIn");



    }
}
