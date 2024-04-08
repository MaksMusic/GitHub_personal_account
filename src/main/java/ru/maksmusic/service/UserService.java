package ru.maksmusic.service;

import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.UserRepository;
import ru.maksmusic.repository.UserRepositoryImpl;

public class UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    public boolean addUser(UserAccount account) {
        if (account != null){
            userRepository.addUser(account);
        }
        return false;
    }
}
