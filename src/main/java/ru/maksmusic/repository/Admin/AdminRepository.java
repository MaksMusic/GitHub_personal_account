package ru.maksmusic.repository.Admin;

import ru.maksmusic.model.AdminAccount;
import ru.maksmusic.model.UserAccount;
import java.util.List;

public interface AdminRepository {
    void addAdmin(AdminAccount adminAccount);
    AdminAccount getAdminByLoginAndPassword (String login, String password);
    List<UserAccount> getUserList();
    void deleteUserFromList(String username);
    void changeUserPassword(String username, String newPassword);
}
