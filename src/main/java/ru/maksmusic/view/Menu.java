package ru.maksmusic.view;

import ru.maksmusic.service.SuperAdminService;
import ru.maksmusic.service.UserService;

/**
 * Menu: класс для управления пользовательским интерфейсом и взаимодействия с
 */
public class Menu {
    UserService userService = new UserService();
    SuperAdminService superAdminService = new SuperAdminService();

    public void start(){
        System.out.println("1 registration user");
        System.out.println("2 registration admin");
        System.out.println("3 registration superAdmin");
        System.out.println("4 LogIn");



    }
}
