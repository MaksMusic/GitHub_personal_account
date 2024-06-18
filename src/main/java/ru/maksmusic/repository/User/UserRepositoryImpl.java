package ru.maksmusic.repository.User;

import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.UserAccount;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final AccountDatabase accountDatabase;

    public UserRepositoryImpl(AccountDatabase accountDatabase) {
        this.accountDatabase = accountDatabase;
    }

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
                // userAccounts.set(account,);
            }
        }

    }
    @Override
    public void fieldUserBy(long id) {
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();

        UserAccount filteredUserById = userAccounts.stream()
                .filter(userAccount -> userAccount.getId() == id)
                .findFirst()
                .orElse(null);

        System.out.println(filteredUserById);
    }

    //Имплементация и переопределение нового метода: returnUserId, в репозитории, о причинах и функционале читай -> UserService
    @Override
    public long returnUserId(String userLogin){
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        for (UserAccount userAccount : userAccounts) {
            if (userAccount.getLogin().equals(userLogin)) {
                return userAccount.getIdUsers();
            }
        }
        return -1; // или выбросить исключение, если пользователь не найден
    }

    @Override
    public UserAccount getUser(String userLogin, String password) {
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        for (UserAccount userAccount : userAccounts) {
            if(userAccount != null){
                if (userAccount.getLogin().equals(userLogin) && userAccount.getPassword().equals(password)){
                    return userAccount;
                }
            }
        }
        return null;
    }
}

