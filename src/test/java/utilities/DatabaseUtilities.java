package utilities;

import io.cucumber.java.it.Ma;
import org.junit.Assert;
import pojos.DatabaseUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtilities {


    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;

//http://test.kesifplus.com:8080
//
//username : tester
//
//password : ueO2axAiA1b5


    public static void createMysqlConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://test.kesifplus.com:3306/kesifplus",
                    "root",
                    "cMk76oD4Z9dP"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createSqliteConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\test\\resources\\SqliteDatabase.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDatabase() {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery(String sql) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> getUsersInfoSqlite() {


        List<Map<String, Object>> mapList = new ArrayList<>();

        executeQuery("SELECT * from Users");
        try {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId", resultSet.getInt(1));
                map.put("email", resultSet.getString(2));
                map.put("firstName", resultSet.getString(3));
                map.put("age", resultSet.getInt(4));

                mapList.add(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }

    public static List<Map<String, Object>> getUsersInfoMysql() {


        List<Map<String, Object>> mapList = new ArrayList<>();

        executeQuery("SELECT * from users");
        try {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId", resultSet.getInt(1));
                map.put("email", resultSet.getString(2));


                mapList.add(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }

    public static void createUserFromDatabase(String email) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("insert into `Users` (userId,email,firstName,age) values (null ,'" + email + "','first',5)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean assertUserCreated(String email) {
        boolean flag = false;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");


            while (resultSet.next()) {
                if (resultSet.getString(2).equals(email)) {
                    flag = true;
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // pojo
    public static List<DatabaseUser> getUserInfo() {
        List<DatabaseUser> databaseUserList = new ArrayList<>();
        DatabaseUser databaseUser;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                databaseUser = new DatabaseUser(
                  resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );

               databaseUserList.add(databaseUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return databaseUserList;
    }

    // map
    public static List<Map<String,Object>> getUserInfoMap() {
        List<Map<String,Object>> mapList = new ArrayList<>();


        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                Map<String,Object> map = new HashMap<>();
                map.put("userId",resultSet.getInt(1));
                map.put("email",resultSet.getString(2));
                map.put("firstName",resultSet.getString(3));
                map.put("age",resultSet.getInt(4));
                mapList.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mapList;
    }

}


