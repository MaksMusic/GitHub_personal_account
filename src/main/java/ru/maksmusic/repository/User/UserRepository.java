package ru.maksmusic.repository.User;

import ru.maksmusic.model.UserAccount;

public interface UserRepository {
    void addUser(UserAccount account);
    void deleteUser(long id);
    void  updateUser(UserAccount account);
    void fieldUserBy(long id);
    //Имплементация нового метода: returnUserLogin, в интерфейсе-репозитории, о причинах и функционале читай -> UserService
    long returnUserId(String userLogin);
   UserAccount getUser (String userLogin,String password);
}
