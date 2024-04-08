package ru.maksmusic.repository;

import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.SuperAdminAccount;

import java.util.List;

public class SuperAdminRepositoryImpl implements SuperAdminRepository{
    AccountDatabase accountDatabase = new AccountDatabase();
    @Override
    public void addSuperAdminAccount(SuperAdminAccount account) {
        List<SuperAdminAccount> superAdminAccount = accountDatabase.getSuperAdminAccounts();
        superAdminAccount.add(account);
    }
}
