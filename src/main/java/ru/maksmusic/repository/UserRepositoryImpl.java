package ru.maksmusic.repository;

import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    AccountDatabase accountDatabase = new AccountDatabase();
    @Override
    public void addUser(UserAccount account) {
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        userAccounts.add(account);
    }

    @Override
    public void deleteUser(long id) {
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        userAccounts.remove(id);
    }

    @Override
    public void updateUser(UserAccount account) {
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        for (UserAccount userAccount : userAccounts) {
            if (userAccount.equals(account)){
                // userAccounts.set(account,)
            }
        }

    }

    @Override
    public void fildUserBy(long id) {
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        System.out.println(userAccounts.get((int) id));
    }
}

