package ru.maksmusic.dataBase;

import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.UserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, отвечающий за управление списком аккаунтов.
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

    public void updateUserAccount(UserAccount user) {
        for (int i = 0; i < userAccounts.size(); i++) {
            if (userAccounts.get(i).getLogin().equals(user.getLogin())) {
                userAccounts.set(i, user);
                break;
            }
        }
    }
}
