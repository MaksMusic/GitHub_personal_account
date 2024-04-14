package ru.maksmusic.repository.User;

import ru.maksmusic.model.UserAccount;

public interface UserRepository {
    void addUser(UserAccount account);
}
