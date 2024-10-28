package vladdossik.jdbc.jpa;

import vladdossik.jdbc.jpa.dao.UserDaoHibernateImpl;
import vladdossik.jdbc.jpa.dao.UserDaoJDBCImpl;
import vladdossik.jdbc.jpa.service.UserService;
import vladdossik.jdbc.jpa.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new UserDaoHibernateImpl());

        userService.createUsersTable();

        userService.saveUser("AAAAA", "BBBBB", (byte) 10);
        userService.saveUser("CCCCC", "DDDDD", (byte) 12);
        userService.saveUser("EEEEE", "EEEEE", (byte) 11);
        userService.saveUser("MARGINAL", "UBUNTU", (byte) 19);

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
