package vladdossik.jdbc.jpa.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import vladdossik.jdbc.jpa.model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Util {
    public static Connection getJdbcConnection() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/jdbc.properties")) {
            properties.load(fileInputStream);
            return DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("USERNAME"),
                    properties.getProperty("PASSWORD"));
        }
        catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getHibernateSessionFactory() {
        Properties configuration = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            configuration.load(classLoader.getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Configuration()
                .addProperties(configuration)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}
