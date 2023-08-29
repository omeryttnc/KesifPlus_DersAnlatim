package stepDefinitions.databaseStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.DatabaseUser;
import utilities.DatabaseUtilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static utilities.DatabaseUtilities.*;

public class week5_e2e_stepDef {
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String updatedEmail = faker.internet().emailAddress();

    @When("user create account with statement")
    public void userCreateAccountWithStatement()  {
        // way 1
//        statement = connection.createStatement();
//        statement.executeUpdate("insert into `Users` (userId,email,firstName,age) values (null ,'" + email + "','first',5)");

        // way 2
        DatabaseUtilities.createUserFromDatabase(email);

    }

    @Then("we should be able to see account created in database with statement")
    public void weShouldBeAbleToSeeAccountCreatedInDatabaseWithStatement() {
        // way 1
//        statement = connection.createStatement();
//        resultSet = statement.executeQuery("select * from users");
//
//        boolean flag = false;
//        while (resultSet.next()) {
//            if (resultSet.getString(2).equals(email)) {
//                flag = true;
//                break;
//            }
//        }
//        Assert.assertTrue(flag);

        // way 2
        Assert.assertTrue(DatabaseUtilities.assertUserCreated(email));
    }

    @When("user update account with statement")
    public void userUpdateAccountWithStatement() throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("update `Users` set email='" + updatedEmail + "'");

    }

    @Then("we should be able to see account updated in database with statement")
    public void weShouldBeAbleToSeeAccountUpdatedInDatabaseWithStatement()  {
        // way 1
//        statement = connection.createStatement();
//        resultSet = statement.executeQuery("select * from users");
//
//        boolean flag = false;
//        while (resultSet.next()) {
//            if (resultSet.getString(2).equals(updatedEmail)) {
//                flag = true;
//                break;
//            }
//        }
//        Assert.assertTrue(flag);

        // way 2
        List<DatabaseUser> userInfo = getUserInfo();
        for (int i = 0; i < userInfo.size(); i++) {
            System.out.println(userInfo.get(i).getEmail());
            System.out.println(userInfo.get(i).getUserId());
            System.out.println(userInfo.get(i).getAge());

        }
        // way 3
        List<Map<String, Object>> userInfoMap = getUserInfoMap();
        for (int i = 0; i < userInfo.size(); i++) {
            System.out.println(userInfoMap.get(i).get("userId"));
            System.out.println(userInfoMap.get(i).get("firstName"));
            System.out.println(userInfoMap.get(i).get("email"));

        }

    }


    @When("user delete account with statement")
    public void userDeleteAccountWithStatement() throws SQLException {

        statement = connection.createStatement();
        statement.executeUpdate("delete from `Users` where email='" + updatedEmail + "'");

    }

    @Then("we should be able to see account deleted in database with statement")
    public void weShouldBeAbleToSeeAccountDeletedInDatabaseWithStatement() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from users");

        boolean flag = true;
        while (resultSet.next()) {
            if (resultSet.getString(2).equals(updatedEmail)) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @When("user create account with preparedStatement")
    public void userCreateAccountWithPreparedStatement() throws SQLException {
        /**
         * statement = connection.createStatement();
         * statement.executeUpdate("insert into `Users` (userId,email,firstName,age) values (null ,'"+email+"','first',5)");
         */
       preparedStatement = connection.prepareStatement("insert into `Users` (userId,email,firstName,age) values (null ,?,?,?)");

       preparedStatement.setString(1,email);
       preparedStatement.setString(2,faker.name().firstName());
       preparedStatement.setInt(3,60);
       preparedStatement.executeUpdate();


    }

    @Then("we should be able to see account created in database with preparedStatement")
    public void weShouldBeAbleToSeeAccountCreatedInDatabaseWithPreparedStatement() {
    }

    @When("user update account with preparedStatement")
    public void userUpdateAccountWithPreparedStatement() throws SQLException {
        /**
         *  statement = connection.createStatement();
         *  statement.executeUpdate("update `Users` set email='" + updatedEmail + "'");
         */

         preparedStatement = connection.prepareStatement("update `Users` set email=?");
         preparedStatement.setString(1,updatedEmail);
         preparedStatement.executeUpdate();
    }

    @Then("we should be able to see account updated in database with preparedStatement")
    public void weShouldBeAbleToSeeAccountUpdatedInDatabaseWithPreparedStatement() {
    }

    @When("user delete account with preparedStatement")
    public void userDeleteAccountWithPreparedStatement() throws SQLException {
        /**
         *  statement = connection.createStatement();
         *  statement.executeUpdate("delete from `Users` where email='" + updatedEmail + "'");
         */

         preparedStatement = connection.prepareStatement("delete from `Users` where email=?");
         preparedStatement.setString(1,updatedEmail);
         preparedStatement.executeUpdate();
    }

    @Then("we should be able to see account deleted in database with preparedStatement")
    public void weShouldBeAbleToSeeAccountDeletedInDatabaseWithPreparedStatement() {
    }
}
