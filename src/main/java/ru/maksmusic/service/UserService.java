package ru.maksmusic.service;


import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.User.UserRepositoryImpl;
import ru.maksmusic.repository.User.UserRepository;

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

    //Для реализации смены пароля по id юзера и для отсутствия нарушений уже готовой логики приложения имплементировал метод возврата логина по паролю
    public String retrunUserLogin(long id){return userRepository.retrunUserLogin(id);};

    public List<UserAccount> getAllUsersSortName(){
        AccountDatabase accountDatabase = new AccountDatabase();
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        Collections.sort(userAccounts, Comparator.comparing(UserAccount::getLogin));
        return userAccounts;
    }


}
