package ru.maksmusic.service;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.User.UserRepositoryImpl;
import ru.maksmusic.repository.User.UserRepository;

import java.util.*;

@FieldDefaults(level = AccessLevel.MODULE)
public class UserService {

    private final UserRepository userRepository;

    public UserService(AccountDatabase accountDatabase) {
        this.userRepository = new UserRepositoryImpl(accountDatabase);
    }

    public boolean addUser(UserAccount account) {
        if (account != null){
            userRepository.addUser(account);
        }
        return false;
    }
    public void  deleteUser(long id){

        userRepository.deleteUser(id);

    }
    public void updateUser(UserAccount account,UserAccount newAccount){
       if(account != null){
       // userRepository.updateUser(account,newAccount);
       }

    }
    public void fieldUserBy(long id){
        userRepository.fieldUserBy(id);
    }

    //Для реализации смены пароля по логину юзера и для отсутствия нарушений уже готовой логики приложения имплементировал метод возврата id по логину
    public long returnUserId(String loginUser){return userRepository.returnUserId(loginUser);}

    public List<UserAccount> getAllUsersSortName(){
        AccountDatabase accountDatabase = new AccountDatabase();
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        userAccounts.sort(Comparator.comparing(UserAccount::getLogin));
        return userAccounts;
    }
    public UserAccount getUserLoginAndPassword(String UserLogin, String UserPassword) {
        return userRepository.getUser(UserLogin, UserPassword);
    }
}
