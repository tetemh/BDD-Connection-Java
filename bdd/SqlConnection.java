package eu.tetemh.jobs.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    private static Connection connection;
    private final String urlbase, host, database, user, pass;

    public SqlConnection(String urlbase, String host, String database, String user, String pass) {
        this.urlbase = urlbase;
        this.host = host;
        this.database = database;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() { return connection; }

    public boolean isConnected() { return connection != null; }

    public void connection() {
        if(!isConnected()) {
            try {
                connection = DriverManager.getConnection(urlbase + host + "/" + database, user, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("BD Connected Jobs");
        }


    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}