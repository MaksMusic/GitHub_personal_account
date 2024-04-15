package ru.maksmusic.repository.SuperAdmin;


import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.UserAccount;

import java.util.List;

public interface SuperAdminRepository {
//Work with SuperAdmin
    void addSuperAdminAccount(SuperAdminAccount SuperAdminAccount);
    SuperAdminAccount getSuperAdminLoginAndPassword (String login, String password);
//Work with Users
    //Реализация просмотра спсика юзеров у СуперАдмина
    List<UserAccount> getUserList();
    //Реализация взаимодействия со списком юзеров СуперАдмина
    void deleteUserFromList(String username);
    void changeUserPassword(String username, String newPassword);
//Work with Admin
    //Реализация просмотра спсика Админов у СуперАдмина
    List<AdminAccount> getAdminList();
    //Реализация взаимодействия со списком Админов СуперАдмина
    void deleteAdminFromList(String adminUsername);
    void changeAdminPassword(String adminUsername, String newAdminPassword);
}