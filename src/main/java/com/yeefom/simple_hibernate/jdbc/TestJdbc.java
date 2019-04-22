package com.yeefom.simple_hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hibernate";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println(connection);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
