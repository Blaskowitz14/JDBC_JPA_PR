package vladdossik.jdbc.jpa.service;

import vladdossik.jdbc.jpa.dao.UserDao;
import vladdossik.jdbc.jpa.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDaoImpl;

    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public void createUsersTable() {
        userDaoImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoImpl.cleanUsersTable();
    }
}
