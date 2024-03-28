package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private Connection connection = null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/rentacar";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "postgres";

    public Connection getConnection() {
        return connection;
    }

    private Db(){
        try{
            this.connection = DriverManager.getConnection(
                    DB_URL,
                    DB_USERNAME,
                    DB_PASSWORD);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
