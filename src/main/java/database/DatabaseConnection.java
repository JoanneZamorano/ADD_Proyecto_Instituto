package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/instituto";
    private static final String USER = "openpg";
    private static final String PASSWORD = "openpgpwd";

    public static Connection conectar(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException("Error de conexión: " + e);
        }
    }
}
