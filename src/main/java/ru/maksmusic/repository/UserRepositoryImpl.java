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
}

