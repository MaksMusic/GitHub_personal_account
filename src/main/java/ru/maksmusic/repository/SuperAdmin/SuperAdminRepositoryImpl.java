package ru.maksmusic.repository.SuperAdmin;

import ru.maksmusic.dataBase.AccountDatabase;
import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.Admin.AdminRepository;
import ru.maksmusic.repository.Admin.AdminRepositoryImpl;
import ru.maksmusic.repository.User.UserRepository;
import ru.maksmusic.repository.User.UserRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class SuperAdminRepositoryImpl implements SuperAdminRepository {
    private AccountDatabase accountDatabase = new AccountDatabase();
    private AdminRepository adminRepository = new AdminRepositoryImpl(accountDatabase);
    private UserRepository userRepository  = new UserRepositoryImpl(accountDatabase);
    private Scanner scanner = new Scanner(System.in);

    public SuperAdminRepositoryImpl(AccountDatabase accountDatabase) {
        this.accountDatabase = accountDatabase;
    }

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
    public void changeUserPasswordById(long id) {
        UserAccount currentUserAccount = userAccounts.get((int) id);
        String newPassword = scanner.next();
        currentUserAccount.setPassword(newPassword);
    }

    @Override
    public List<AdminAccount> getAdminList(){
        return adminAccounts;
    }
    @Override
    public void deleteAdminFromList(String adminUsername){
        adminRepository.deleteUserFromList(adminUsername);
    }
    @Override
    public void changeAdminPassword(String adminUsername){
        System.out.println("Введите новый пароль");
        String newPassword = scanner.next();
        for (AdminAccount admin : adminAccounts) {
            if (admin.getLogin().equals(adminUsername)) {
                admin.setPassword(newPassword);
                System.out.println("Пароль успешно изменён");
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
    @Override
    public void findUserById(long id) {
        UserAccount currentUserAccount = userAccounts.get((int) id);
        System.out.println(currentUserAccount);
    }

    @Override
    public void getUserBalanceById(long id) {
        List<UserAccount> userAccounts = accountDatabase.getUserAccounts();
        UserAccount currentUserAccount = userAccounts.stream()
                .filter(user -> user.getIdUsers() == id)
                .findFirst()
                .orElse(null);
        if (currentUserAccount != null) {
            double currentUserBalance = currentUserAccount.getBalance();
            System.out.println("Баланс пользователя " + currentUserAccount.getLogin() + ": " + currentUserBalance);
        } else {
            System.out.println("Пользователь с указанным id не найден.");
        }
    }
}