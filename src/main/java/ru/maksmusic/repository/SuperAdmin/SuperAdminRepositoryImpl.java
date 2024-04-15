package ru.maksmusic.repository.SuperAdmin;

import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.UserAccount;

import java.util.List;

public class SuperAdminRepositoryImpl implements SuperAdminRepository {
    private AccountDatabase accountDatabase = new AccountDatabase();
    List<SuperAdminAccount> superAdminAccounts = accountDatabase.getSuperAdminAccounts();
    List<AdminAccount> adminAccounts = accountDatabase.getAdminAccounts();
    List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
    @Override
    public void addSuperAdminAccount(SuperAdminAccount SuperAdminAccount) {
    }
    @Override
    public SuperAdminAccount getSuperAdminLoginAndPassword (String login, String password){
        for (SuperAdminAccount account : superAdminAccounts) {
            if (account != null){
                if (account.getLogin().equals(login) && account.getPassword().equals(password)){
                    return account;
                }
            }
        }
        return null;
    }
    @Override
    public List<UserAccount> getUserList(){
        return  userAccounts;
    }
    @Override
    public void deleteUserFromList(String username){

    }
    @Override
    public void changeUserPassword(String username, String newPassword){

    }
    @Override
    public List<AdminAccount> getAdminList(){
        return adminAccounts;
    }
    @Override
    public void deleteAdminFromList(String adminUsername){

    }
    @Override
    public void changeAdminPassword(String adminUsername, String newAdminPassword){

    }
}