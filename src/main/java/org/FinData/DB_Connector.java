package org.FinData;

import java.sql.*;

@SuppressWarnings("CallToDriverManagerGetConnection")
public class DB_Connector {
    // url, username and password are in private Resource class
    private static final String url = new Resource ().getUrl ();
    private static final String user = new Resource ().getUser ();
    private static final String password = new Resource ().getPwd ();

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection (url, user, password);
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
            return null;
        }
    }
}
