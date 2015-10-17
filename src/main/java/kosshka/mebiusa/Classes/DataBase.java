package kosshka.mebiusa.Classes;

import java.sql.*;

/**
 * Created by kosshka_mebiusa on 16.10.15.
 */
public class DataBase {

    private static String dbURL = "jdbc:mysql://localhost/";
    private static String dbLogin = "root";
    private static String dbPassword = "masha555UB";
    private static String dbDriver = "com.mysql.jdbc.Driver";

    private static Connection connection;
    private static Statement stmt;

    private static Connection getDBConnection(){
        Connection connection = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword);
        } catch (Exception e){

        }
        return connection;
    }

    public static void start() throws SQLException{
        connection = getDBConnection();
        stmt = connection.createStatement();
        try {
            stmt.execute("USE mydatabase");
        } catch (Exception e){
            stmt.execute("CREATE DATABASE mydatabase;");
            stmt.execute("USE mydatabase");
            stmt.execute("CREATE TABLE Users ("
                    + "login CHAR(20) NOT NULL,"
                    + "password CHAR(20) NOT NULL,"
                    + "city CHAR(20) NOT NULL,"
                    + "PRIMARY KEY (login)"
                    + ");");
        }
    }

    public static ResultSet find(String login, String password) throws SQLException{
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Users WHERE login='%s' AND password ='%s';", login, password));
        return rs;
    }

    public static void add(String login, String password, String city) throws SQLException{
        stmt.execute(String.format("INSERT INTO Users VALUES ('%s', '%s', '%s');",
                login, password, city));
    }

}
