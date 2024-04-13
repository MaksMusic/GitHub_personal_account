package ru.maksmusic.service;

import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.User.UserRepository;
import ru.maksmusic.repository.User.UserRepositoryImpl;

public class UserService {
    UserRepository userRepository = new UserRepositoryImpl();

    public boolean addUser(UserAccount account) {
        if (account != null){
            userRepository.addUser(account);
        }
        return false;
    }
}
