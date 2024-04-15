package ru.maksmusic.service;

import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.model.UserAccount;
import ru.maksmusic.repository.SuperAdmin.SuperAdminRepository;
import ru.maksmusic.repository.SuperAdmin.SuperAdminRepositoryImpl;

import java.util.List;

public class SuperAdminService {
    private SuperAdminRepository superAdminRepository = new SuperAdminRepositoryImpl();
    public void addSuperAdminAccount(SuperAdminAccount newaccount){
        superAdminRepository.addSuperAdminAccount(newaccount);
    }
    public SuperAdminAccount getSuperAdminUseLoginAndPassword(String superAdminLogin, String SuperAdminPassword){
        return superAdminRepository.getSuperAdminLoginAndPassword(superAdminLogin, SuperAdminPassword);
    }
//Work with Users
    public List<UserAccount> getUserList() {
        return superAdminRepository.getUserList();
    }
    public void deleteUserFromList(String username) {
        superAdminRepository.deleteUserFromList(username);
    }
    public void changeUserPassword(String username, String newPassword){
        superAdminRepository.changeUserPassword(username,newPassword);
    }

//Work with Admin
    public List<AdminAccount> getAdminList(){
        return superAdminRepository.getAdminList();
    }

    public void deleteAdminFromList(String adminUsername){
        superAdminRepository.deleteAdminFromList(adminUsername);
    }
    public void changeAdminPassword(String adminUsername, String newAdminPassword){
        superAdminRepository.changeAdminPassword(adminUsername, newAdminPassword);
    }

}
