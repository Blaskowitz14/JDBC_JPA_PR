package vladdossik.jdbc.jpa.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vladdossik.jdbc.jpa.model.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    public static Connection getJdbcConnection() {
        Properties properties = getProperties();
        try {
            return DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("USERNAME"),
                    properties.getProperty("PASSWORD"));
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getHibernateSessionFactory() {
        return new Configuration()
                .addProperties(getProperties())
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            properties.load(classLoader.getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
