package repository;

import model.Admin;
import model.User;
import util.UserRepositoryInterface;
import java.util.List;

public class AdminRepository extends AbstractRepository<Admin> implements UserRepositoryInterface {

    @Override
    public User searchByUsername(String username) {
        List<Admin> admins = findAll();

        for (Admin admin: admins) {
            if (admin.getUsername().equals(username)) return admin;
        }

        return null;
    }
}
