package ru.maksmusic.service;

import ru.maksmusic.model.SuperAdminAccount;
import ru.maksmusic.repository.SuperAdminRepository;
import ru.maksmusic.repository.SuperAdminRepositoryImpl;

public class SuperAdminService {
    SuperAdminRepository superAdminRepository = new SuperAdminRepositoryImpl();
    public boolean addSuperAdminAccount(SuperAdminAccount account){
        if(account != null){
            superAdminRepository.addSuperAdminAccount(account);
        }
        return false;
    }
}
