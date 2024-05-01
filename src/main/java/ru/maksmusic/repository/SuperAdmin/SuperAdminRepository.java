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
    void findUserById(long id);
    //Реализация просмотра спсика юзеров у СуперАдмина
    List<UserAccount> getUserList();
    //Реализация взаимодействия со списком юзеров СуперАдмина
    void deleteUserFromList(long id);
    void changeUserPasswordById(long id);
    void getUserBalanceById(long id);

//Work with Admin
    //Реализация просмотра спсика Админов у СуперАдмина
    List<AdminAccount> getAdminList();
    //Реализация взаимодействия со списком Админов СуперАдмина
    void deleteAdminFromList(String adminUsername);
    void changeAdminPassword(String adminUsername);

//Work with balance
    //Реализация взаимодействия с бланасом пользователей
    void setUsersBalance(long id, double balance);
}