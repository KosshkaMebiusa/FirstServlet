package kosshka.mebiusa.Classes;

import kosshka.mebiusa.Weather.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static String dbURL = "jdbc:mysql://localhost/";
    private static String dbLogin = "root";
    private static String dbPassword = "mypassword";
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
            stmt.execute("CREATE TABLE `mydatabase`.`Users` (" +
                    "  `idUsers` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NOT NULL," +
                    "  `password` VARCHAR(45) NOT NULL," +
                    "  `city` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`idUsers`)," +
                    "  UNIQUE INDEX `login_UNIQUE` (`login`));");
            stmt.execute("CREATE TABLE `mydatabase`.`Weather` (" +
                    "  `idWeather` INT NOT NULL AUTO_INCREMENT," +
                    "  `date` DATE NULL," +
                    "  `time` TIME NULL," +
                    "  `discription` VARCHAR(45) NULL," +
                    "  `temperature` INT NULL," +
                    "  `pressure` INT NULL," +
                    "  `windSpeed` INT NULL," +
                    "  `windDirection` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`idWeather`));");

        }
    }

    public static ResultSet findUser(String login, String password) throws SQLException{
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Users WHERE login='%s' AND password ='%s';", login, password));
        return rs;
    }

    public static void addUser(String login, String password, String city) throws SQLException{
        stmt.execute(String.format("INSERT INTO Users (login, password, city) VALUES ('%s', '%s', '%s');",
                login, password, city));
    }

    public static ResultSet findWeather(String login, String password) throws SQLException{
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM Users WHERE login='%s' AND password ='%s';", login, password));
        return rs;
    }

    public static void addWeather(String login, String password, String city) throws SQLException{
        stmt.execute(String.format("INSERT INTO Users (login, password, city) VALUES ('%s', '%s', '%s');",
                login, password, city));
    }

    private static ResultSet allWeatherRS() throws SQLException{
        ResultSet rs = stmt.executeQuery("SELECT * FROM Weather;");
        return rs;
    }

    public static List<Weather> allWeather(){
        try {
            ResultSet rs = allWeatherRS();
            List<Weather> weatherList = new ArrayList<>();
            if (rs.next()) {
                Weather weather = new Weather(rs.getDate("date"), rs.getTime("time"), rs.getString("discription"), rs.getInt("temperature"), rs.getInt("pressure"),
                        rs.getInt("humidity"), rs.getInt("windSpeed"), rs.getInt("windDirection"));
                weatherList.add(weather);
            }

            return weatherList;
        } catch (Exception e){
            return null;
        }
    }

}
