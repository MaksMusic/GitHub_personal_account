package ru.maksmusic.service;


import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.UserRepositoryImpl;
import ru.maksmusic.repository.UserRepository;

import java.util.*;

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

    public List<UserAccount> getAllUsersSortName(){
        AccountDatabase accountDatabase = new AccountDatabase();
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        Collections.sort(userAccounts, Comparator.comparing(UserAccount::getLogin));
        return userAccounts;
    }


}
