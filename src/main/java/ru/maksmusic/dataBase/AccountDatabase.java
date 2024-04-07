package ru.maksmusic.dataBase;

import ru.maksmusic.model.UserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * класс, отвечающий за управление списком аккаунтов.
 */
public  class AccountDatabase {
   private List<UserAccount> userAccounts = new ArrayList<>();


    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
