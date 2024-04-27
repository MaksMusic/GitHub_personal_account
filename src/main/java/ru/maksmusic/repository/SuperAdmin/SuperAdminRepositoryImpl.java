package ru.maksmusic.repository.SuperAdmin;

import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.Admin.AdminRepository;
import ru.maksmusic.repository.Admin.AdminRepositoryImpl;
import ru.maksmusic.repository.UserRepository;
import ru.maksmusic.repository.UserRepositoryImpl;

import java.util.List;

public class SuperAdminRepositoryImpl implements SuperAdminRepository {
    private AccountDatabase accountDatabase = new AccountDatabase();
    private AdminRepository adminRepositroy = new AdminRepositoryImpl();
    private UserRepository userRepository  = new UserRepositoryImpl();

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
    public void deleteUserFromList(long id){
        userRepository.deleteUser(id);
    }
    @Override
    public void changeUserPassword(String username, String newPassword){
        adminRepositroy.changeUserPassword(username, newPassword);
    }
    @Override
    public List<AdminAccount> getAdminList(){
        return adminAccounts;
    }
    @Override
    public void deleteAdminFromList(String adminUsername){
        adminRepositroy.deleteUserFromList(adminUsername);
    }
    @Override
    public void changeAdminPassword(String adminUsername, String newAdminPassword){
        for (AdminAccount admin : adminAccounts) {
            if (admin.getLogin().equals(adminUsername)) {
                admin.setPassword(newAdminPassword);
                break;
            }
        }
    }
    @Override
    public void setUsersBalance(long id, double balance){
        for (UserAccount userAccount : userAccounts) {
            if(id == userAccount.getId()){
                userAccount.setBalance(balance);
                break;
            }
        }
    }
}