package stepDefinitions.databaseStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import utilities.DatabaseUtilities;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class week4 {

    Connection connection;

    Statement statement;

    PreparedStatement preparedStatement;

    ResultSet resultSet;


    /*

    CRUD
    method      return          use method      sql syntex

    Read     -> ResultSet    -> executeQuery   Select * FROM tableName

     ----------------------------------------------------------------------------------
    Create   -> int          -> executeUpdate  INSERT INTO columnNames VALUES (columValues)

    Update   -> int          -> executeUpdate  UPDATE degisecekcolumn SET neIleDegisecek

    Delete   -> int          -> executeUpdate  DELETE silinecekColumn FROM tableName


     */

    String email = "salidenemdde@sda.sd";

    @Given("connection mysql database")
    public void connectionMysqlDatabase() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://www.kesifplus.com:3306/kesifplus",
                    "root",
                    "12345678"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @When("we create new user")
    public void weCreateNewUser() {
    }

    @Then("assert new user is in database")
    public void assertNewUserIsInDatabase() {

        boolean flag = false;
        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `users`");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            while (resultSet.next()) {

                System.out.println("resultSet.getString(\"email\") = " + resultSet.getString("email"));
                System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));
                if (resultSet.getString("email").equals(email)) {
                    flag = true;
                    break;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("kullanici bulunumadi ", flag);

    }


    @Test
    public void sqliteDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\test\\resources\\SqliteDatabase.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from Users");

            while (resultSet.next()){
                System.out.println("resultSet.getString(\"firstName\") = " + resultSet.getString("firstName"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void name() {

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home") + "\\Downloads");
    }

    @When("sql database bilgisi yazdir")
    public void sqlDatabaseBilgisiYazdir() {
        List<Map<String, Object>> usersInfo = DatabaseUtilities.getUsersInfoMysql();

        System.out.println("usersInfo.get(0).get(\"email\") = " + usersInfo.get(0).get("email"));

        System.out.println("usersInfo.get(0).get(\"userId\") = " + usersInfo.get(0).get("userId"));

    }
}
