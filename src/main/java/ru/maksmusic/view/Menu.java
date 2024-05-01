package ru.maksmusic.view;

import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.service.AdminService;
import ru.maksmusic.service.GenerateID;
import ru.maksmusic.service.SuperAdminService;
import ru.maksmusic.service.UserService;

import java.util.Scanner;

/**
 * Menu: класс для управления пользовательским интерфейсом и взаимодействия с
 */
public class Menu {
    AdminService adminService = new AdminService();
    UserService userService = new UserService();
    SuperAdminService superAdminService = new SuperAdminService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("1 registration user");
        System.out.println("2 registration admin");
        System.out.println("3 registration superAdmin");
        System.out.println("4 LogIn");

        String answer = scanner.next();
        switch (answer) {
            case "1" -> {
                    regUser();
            }
            case "2" -> {
                    regAdmin();
            }
            case "3" -> {
                    regSuperAdmin();
            }
            default -> {

            }
        }


    }

    private void regUser(){
        System.out.println("Ввидите логин : ");
        String name = scanner.next();
        System.out.println("Ввидите пароль : ");
        String password = scanner.next();
        UserAccount userAccount = new UserAccount(GenerateID.getId(),name,password);

        userService.addUser(userAccount);
    }

    private void regAdmin(){
        //принять информацию о админе и добавить его с помощью adminService
    }

    private void regSuperAdmin(){
        System.out.println("Ввидите логин : ");
        String name = scanner.next();
        System.out.println("Ввидите пароль : ");
        String password = scanner.next();
        SuperAdminAccount superAdminAccount = new SuperAdminAccount(GenerateID.getId(),name,password);

        //superAdminService еще не создан
            //добавил метод addSuperAdminAccount
        superAdminService.addSuperAdminAccount(superAdminAccount);
    }
    private void logIn(){
        System.out.println("Введите в роли кого вы хотите войти");
        System.out.println("1 - user");
        System.out.println("2 - admin");
        System.out.println("3 - super admin");

        //далее принять число и принять логин и пароль и проверить есть ли данные в бд
        //или нету вернуть в главное меню(если есть в запустить метод lkUser() lkAdmin() или lkSuperAdmin()
        // куда передать самого юзера или админа или супер админа)


    }
    private void lkUser(UserAccount userAccount){
        while (true) {
            // пункт 1 вывести информацию о юзере
            // пункт 2 сменить пароль
            // пункт 3 просмотр баланса
            // 0 - выйти с лк (остановить цикл)
            //тут свитч кейс
            //Реализация работы личного кабинета для Юзера
                //Просьба к юзеру ввести указанные числа для дальнейшего взаимодействия с приложением
            System.out.println("Введите 1 чтобы посмотреть Вашу информацию, по вашему ID.");
            System.out.println("Введите 2 чтобы сменить ваш пароль по ID.");
            System.out.println("Введите 3 чтобы посмотреть баланс по ID.");
            System.out.println("Введите 0 если хотите выйти.");
                //Получение числа от юзера через Scanner
            String answerUser = scanner.next();
                //Обработка полученного значения от юзера и дальнейшее взаимодействие с юзером
            switch(answerUser){
                //Действие при получении значения 1 -> просим ввести юзера его ID(?) после выводим всю информацию о юзере
                case "1" -> {
                    System.out.print("Пожалуйста, введите ваш ID: ");
                    long idUsers = Long.parseLong(scanner.next());
                    userService.fildUserBy(idUsers);
                }
                //Действие при получении значения 2 -> просим ввести юзера его ID и новый пароль и меняем юзеру пароль
                case "2" -> {
                    System.out.print("Пожалуйста, введите ваш ID: ");
                    long idUsers = Long.parseLong(scanner.next());
                    System.out.print("Пожалуйста, введите новый пароль: ");
                    String newPassword = scanner.nextLine();
                    adminService.changeUserPassword(userService.retrunUserLogin(idUsers), newPassword);
                }
                //Действие при получении значения 3 -> просим ввести юзера его ID выводим баланс юзера
                case "3" -> {
                    System.out.print("Пожалуйста, введите ваш ID: ");
                    long idUsers = Long.parseLong(scanner.next());
                    superAdminService.getUserBalanceById(idUsers);
                }
                //Действие при получении значения 3 -> выводим надпись "Выход" и выходим из цикла
                case "0" -> {
                    System.out.print("Exist");
                }
            }
        break;
        }
    }

    private void lkAdmin(AdminAccount userAccount){
        while (true) {
            // пункт 1 вывести информацию о юзерах (Всех)
            // пункт 2 сменить юзеру пароль по id
            // пункт 3 просмотр баланса юзера по id
            // сменить свой пароль
            // 0 - выйти с лк (остановить цикл)
            String answer = scanner.next();
            //тут свитч кейс
        }
    }
    private void lkSuperAdmin(SuperAdminAccount superAdminAccount){
        // пункт 1 вывести информацию о юзере по id
        // пункт 2 сменить юзеру пароль по id
        // пункт 3 просмотр баланса юзера по id
        // пункт 4 Вывести всех админов
        // пункт 5 сменить пароль админу
        // пункт 6 удалить аккаунт админа
        // пункт 7 удалить аккаунт юзера
        // сменить свой пароль
        //тут свитч кейс
        while (true) {
            System.out.println("1 вывести информацию о юзере по id");
            System.out.println("2 сменить юзеру пароль по id");
            System.out.println("3 просмотр баланса юзера по id");
            System.out.println("4 вывести всех админов");
            System.out.println("5 сменить пароль админу");
            System.out.println("6 удалить аккаунт админа");
            System.out.println("7 удалить аккаунт юзера");
            String answer = scanner.next();
            switch (answer) {
                case "1" -> {
                    System.out.println("Введите id пользователя");
                    long userId = Long.parseLong(scanner.next());
                    superAdminService.findUserById(userId);
                }
                case "2" -> {
                    System.out.println("Введите id пользователя");
                    long userId = Long.parseLong(scanner.next());
                    superAdminService.changeUserPasswordById(userId);
                }
                case "3" -> {
                    System.out.println("Введите id пользователя");
                    long userId = Long.parseLong(scanner.next());
                    superAdminService.getUserBalanceById(userId);
                }
                case "4" -> {
                    superAdminService.getAdminList();
                }
                case "5" -> {
                    System.out.println("Введите логин админа");
                    String adminName = scanner.next();
                    superAdminService.changeAdminPassword(adminName);
                }
                case "6" -> {
                    System.out.println("Введите логин админа");
                    String adminName = scanner.next();
                    superAdminService.deleteAdminFromList(adminName);
                }
                case "7" -> {
                    System.out.println("Введите id юзера");
                    long userId = Long.parseLong(scanner.next());
                    superAdminService.deleteUserFromList(userId);
                }
            }
        }
    }
}
