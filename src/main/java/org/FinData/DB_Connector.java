package org.FinData;

import java.sql.*;

public class DB_Connector {

    private static final String url ="jdbc:mysql://localhost:3306/finstatements";
    private static final String user = "java_app";
    private static final String password = "G>*>(hG@aaV6ds59@Txn";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection (url, user, password);
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
            return null;
        }
    }
}
