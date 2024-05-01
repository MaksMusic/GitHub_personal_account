package ru.maksmusic.repository.User;

import ru.maksmusic.model.UserAccount;

public interface UserRepository {
    void addUser(UserAccount account);
    void deleteUser(long id);
    void  updateUser(UserAccount account);
    void fildUserBy(long id);

    //Имплементация нового метода: retrunUserLogin, в интерфейсе-репозитории, о причинах и функционале читай -> UserService
    String retrunUserLogin(long id);
}
