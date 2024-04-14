package ru.maksmusic.service;

import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.Admin.AdminRepository;
import ru.maksmusic.repository.Admin.AdminRepositoryImpl;

import java.util.List;

public class AdminService {
    AdminRepository adminRepository = new AdminRepositoryImpl();

    public void addAdmin (AdminAccount newAccount) {
            adminRepository.addAdmin(newAccount);
    }
    public AdminAccount getAdminByLoginAndPassword (String login, String password) {
        return adminRepository.getAdminByLoginAndPassword(login,password);
    }
    public List<UserAccount> getUserList() {
        return adminRepository.getUserList();
    }
    public void deleteUserFromList(String username) {
        adminRepository.deleteUserFromList(username);
    }
    public void changeUserPassword(String username, String newPassword){
        adminRepository.changeUserPassword(username,newPassword);
    }
}
