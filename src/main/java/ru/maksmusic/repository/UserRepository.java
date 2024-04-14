package ru.maksmusic.repository;

import ru.maksmusic.model.UserAccount;

public interface UserRepository {
    void addUser(UserAccount account);
}
