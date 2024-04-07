package ru.maksmusic.dataBase;

import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.UserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * класс, отвечающий за управление списком аккаунтов.
 */
public class AccountDatabase {
    private List<UserAccount> userAccounts = new ArrayList<>();
    private List<AdminAccount> adminAccounts = new ArrayList<>();
    private List<SuperAdminAccount> superAdminAccounts = new ArrayList<>();


    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public List<AdminAccount> getAdminAccounts() {
        return adminAccounts;
    }

    public List<SuperAdminAccount> getSuperAdminAccounts() {
        return superAdminAccounts;
    }
}
