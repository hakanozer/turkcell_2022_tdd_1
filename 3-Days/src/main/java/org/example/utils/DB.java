package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    final private String driver = "org.h2.Driver";
    final private String url = "jdbc:h2:file:~/turkcell_tdd";
    final private String username = "sa";
    final private String password = "sa";

    private Connection conn = null;
    public Connection connect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Success");
        }catch (Exception ex) {
            System.err.println("Connecion Fail");
        }
        return conn;
    }

    public void close() {
        try {
            if ( conn != null && !conn.isClosed() ) {
                conn.close();
            }
        }catch (Exception ex) {
            System.err.println("Close Error");
        }
    }

}