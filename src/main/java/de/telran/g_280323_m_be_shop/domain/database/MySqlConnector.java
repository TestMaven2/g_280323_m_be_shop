package de.telran.g_280323_m_be_shop.domain.database;

import java.sql.Connection;
import java.sql.DriverManager;

import static de.telran.g_280323_m_be_shop.constants.Constants.*;

public class MySqlConnector {

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);
            // jdbc:mysql://localhost:3306/280323-m-be-shop?user=root&password=55555
            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_URL, DB_NAME, DB_USERNAME, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}