package ru.maksmusic.view;

import ru.maksmusic.dataBase.AccountDatabase;
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
    AccountDatabase accountDatabase = new AccountDatabase();
    AdminService adminService = new AdminService(accountDatabase);
    UserService userService = new UserService(accountDatabase);
    SuperAdminService superAdminService = new SuperAdminService(accountDatabase);
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("1 registration user");
            System.out.println("2 registration admin");
            System.out.println("3 registration superAdmin");
            System.out.println("4 LogIn");

            String answer = scanner.next();
            switch (answer) {
                case "1" -> regUser();
                case "2" -> regAdmin();
                case "3" -> regSuperAdmin();
                case "4" -> logIn();
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void regUser() {
        System.out.println("Введите логин : ");
        String name = scanner.next();
        System.out.println("Введите пароль : ");
        String password = scanner.next();
        UserAccount userAccount = new UserAccount(GenerateID.getId(), name, password);

        userService.addUser(userAccount);
        System.out.println(accountDatabase.getUserAccounts());
    }

    private void regAdmin() {
        System.out.println("Введите логин : ");
        String name = scanner.next();
        System.out.println("Введите пароль : ");
        String password = scanner.next();
        AdminAccount adminAccount = new AdminAccount(GenerateID.getId(), name, password);

        adminService.addAdmin(adminAccount);
    }

    private void regSuperAdmin() {
        System.out.println("Введите логин : ");
        String name = scanner.next();
        System.out.println("Введите пароль : ");
        String password = scanner.next();
        SuperAdminAccount superAdminAccount = new SuperAdminAccount(GenerateID.getId(), name, password);

        superAdminService.addSuperAdminAccount(superAdminAccount);
    }

    private void logIn() {
        System.out.println("Введите в роли кого вы хотите войти");
        System.out.println("1 - user");
        System.out.println("2 - admin");
        System.out.println("3 - super admin");
        String number = scanner.next();
        switch (number) {
            case "1" -> {
                System.out.println("Введите логин : ");
                String name = scanner.next();
                System.out.println("Введите пароль : ");
                String password = scanner.next();
                for (UserAccount userAccount : accountDatabase.getUserAccounts()) {
                    if (userAccount != null && userAccount.getLogin().equals(name) && userAccount.getPassword().equals(password)) {
                        lkUser(userAccount);
                        return;
                    }
                }
                System.out.println("Неверный логин или пароль");
            }
            case "2" -> {
                System.out.println("Введите логин : ");
                String name = scanner.next();
                System.out.println("Введите пароль : ");
                String password = scanner.next();
                for (AdminAccount adminAccount : accountDatabase.getAdminAccounts()) {
                    if (adminAccount != null && adminAccount.getLogin().equals(name) && adminAccount.getPassword().equals(password)) {
                        lkAdmin(adminAccount);
                        return;
                    }
                }
                System.out.println("Неверный логин или пароль");
            }
            case "3" -> {
                System.out.println("Введите логин : ");
                String name = scanner.next();
                System.out.println("Введите пароль : ");
                String password = scanner.next();
                for (SuperAdminAccount superAdminAccount : accountDatabase.getSuperAdminAccounts()) {
                    if (superAdminAccount != null && superAdminAccount.getLogin().equals(name) && superAdminAccount.getPassword().equals(password)) {
                        lkSuperAdmin(superAdminAccount);
                        return;
                    }
                }
                System.out.println("Неверный логин или пароль");
            }
            default -> System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }

    private void lkUser(UserAccount userAccount) {
        while (true) {
            System.out.println("Текущий аккаунт -" + userAccount.getLogin());
            System.out.println("Введите 1 чтобы посмотреть Вашу информацию, по вашему логину.");
            System.out.println("Введите 2 чтобы сменить ваш пароль по логину.");
            System.out.println("Введите 3 чтобы посмотреть баланс по логину.");
            System.out.println("Введите 0 если хотите выйти.");
            String answerUser = scanner.next();
            switch (answerUser) {
                case "1" -> {
                    System.out.print("Пожалуйста, введите ваш логин: ");
                    String userLogin = scanner.next();
                    userService.fieldUserBy(userService.returnUserId(userLogin));
                }
                case "2" -> {
                    System.out.print("Пожалуйста, введите ваш логин: ");
                    String userLogin = scanner.next();
                    System.out.print("Пожалуйста, введите новый пароль: ");
                    String newPassword = scanner.next();
                    adminService.changeUserPassword(userLogin, newPassword);
                }
                case "3" -> {
                    System.out.print("Пожалуйста, введите ваш логин: ");
                    String userLogin = scanner.next();
                    superAdminService.getUserBalanceById(userService.returnUserId(userLogin));
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void lkAdmin(AdminAccount userAccount) {
        while (true) {
            System.out.println("Введите 1 чтобы вывести информацию о юзерах.");
            System.out.println("Введите 2 чтобы сменить юзеру пароль по id.");
            System.out.println("Введите 3 чтобы просмотреть баланс юзера по id.");
            System.out.println("Введите 0 чтобы выйти.");
            String answer = scanner.next();
            switch (answer) {
                case "1" -> System.out.println(adminService.getUserList());
                case "2" -> {
                    System.out.println("Введите id пользователя для смены пароля");
                    String userId = scanner.next();
                    System.out.println("Введите новый пароль");
                    String newPasswordUser = scanner.next();
                    adminService.changeUserPassword(userId, newPasswordUser);
                }
                case "3" -> {
                    System.out.println("Введите id пользователя для просмотра баланса ");
                    long userId = scanner.nextLong();
                    superAdminService.getUserBalanceById(userId);
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void lkSuperAdmin(SuperAdminAccount superAdminAccount) {
        while (true) {
            System.out.println("1 вывести информацию о юзере по id");
            System.out.println("2 сменить юзеру пароль по id");
            System.out.println("3 просмотр баланса юзера по id");
            System.out.println("4 вывести всех админов");
            System.out.println("5 сменить пароль админу");
            System.out.println("6 удалить аккаунт админа");
            System.out.println("7 удалить аккаунт юзера");
            System.out.println("0 выйти");
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
                case "4" -> superAdminService.getAdminList();
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
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
