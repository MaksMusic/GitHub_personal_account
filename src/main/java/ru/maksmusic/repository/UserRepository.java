package ru.maksmusic.repository;

import ru.maksmusic.model.UserAccount;

public interface UserRepository {
    void addUser(UserAccount account);
    void deleteUser(long id);
    void  updateUser(UserAccount account);
    void fildUserBy(long id);
}
