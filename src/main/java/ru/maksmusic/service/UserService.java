package ru.maksmusic.service;

import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.UserRepository;
import ru.maksmusic.repository.UserRepositoryImpl;

import java.util.Scanner;

public class UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    public boolean addUser(UserAccount account) {
        if (account != null){
            userRepository.addUser(account);
        }
        return false;
    }
    public void  deleteUser(long id){

        userRepository.deleteUser(id);

    }
    public void updateUser(UserAccount account){
       if(account != null){
        userRepository.updateUser(account);

       }

    }
    public void fildUserBy(long id){
        userRepository.fildUserBy(id);
    }

}
