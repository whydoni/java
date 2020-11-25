package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    public Connection con;
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String db = "jdbc:mysql://localhost:3306/worker";
    public String uname = "root";
    public String pass = "Rahasia=123";

    public Connection on() {
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(db, uname, pass);

        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        return con;
    }

    public void off() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
