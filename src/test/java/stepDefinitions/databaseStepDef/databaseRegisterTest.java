package stepDefinitions.databaseStepDef;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DatabaseUtilities;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;
import static utilities.DatabaseUtilities.resultSet;

public class databaseRegisterTest {
    public static Faker faker = new Faker();
    String email = "a" + new Random().nextInt(15) + faker.internet().emailAddress();

    @Given("user connects to the database")
    public void userConnectsToTheDatabase() {
        DatabaseUtilities.createMysqlConnection();
    }

    @When("user registers through UI")
    public void userRegistersThroughUI() {
        driver.get("https://test.kesifplus.com/register");

        //1. yontem
        String password = faker.internet().password(8, 16, true, true, true);
        commonPage.getRegisterPage().email.sendKeys(email);
        commonPage.getRegisterPage().password.sendKeys(password);
        commonPage.getRegisterPage().password2.sendKeys(password);

        commonPage.getRegisterPage().submit.click();

        //2. yontem
//        email = commonPage.getRegisterPage().register();
    }

    @Then("user verifies registered user exists in the database")
    public void userVerifiesRegisteredUserExistsInTheDatabase() throws SQLException {
        //1. yontem
        String query = "SELECT * FROM users WHERE email = '" + email + "' ORDER BY userid DESC";
        DatabaseUtilities.executeQuery(query);

        if (resultSet.next())
            System.out.println("Kullanici bulundu");
        else
            System.out.println("Kullanici bulunamadi");


        //2. yontem
        boolean flag = false;
        DatabaseUtilities.executeQuery("SELECT * FROM users ORDER BY userid DESC");
        while (resultSet.next()) {
            String emailFromRS = resultSet.getString("email");
            if (emailFromRS.equals(email)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @And("user verifies following column names are present in the users table")
    public void userVerifiesFollowingColumnNamesArePresentInTheUsersTable(DataTable dataTable) throws SQLException {
        List<String> columnNames = dataTable.column(0); //{userid, email}
        DatabaseUtilities.executeQuery("Select * from users");
        ResultSetMetaData rsmd = resultSet.getMetaData();

        for (String columnName : columnNames) { //userid email
            boolean flag = false;
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (columnName.equals(rsmd.getColumnName(i))) {
                    flag = true;
                    break;
                }
            }
            Assert.assertTrue(flag);
        }

    }

    @And("user verifies all emails are unique")
    public void userVerifiesAllEmailsAreUnique() throws SQLException {
        DatabaseUtilities.executeQuery("SELECT * from users");
        ArrayList<String> allEmails = new ArrayList<>();
        while (resultSet.next()) {
            allEmails.add(resultSet.getString("email"));
        }

//        Set<String> uniqueEmails = (Set<String>) allEmails;
        Set<String> uniqueEmails = new HashSet<>(allEmails);
        Assert.assertTrue(allEmails.size()==uniqueEmails.size());
//        Collections. -> compare methodu

        //2. yontem
        DatabaseUtilities.executeQuery("Select count(email) as emailcount from users");
        resultSet.next();
        int allEmailCount = resultSet.getInt("emailcount");
        System.out.println("all email count: "+ allEmailCount);

        DatabaseUtilities.executeQuery("Select count(distinct email) as emailcount from users");
        resultSet.next();
        int uniqueEmailCount = resultSet.getInt("emailcount");
        System.out.println("unique email count: "+ uniqueEmailCount);

        Assert.assertTrue(allEmailCount==uniqueEmailCount);
    }

    @When("user closes the connection")
    public void userClosesTheConnection() {
        DatabaseUtilities.closeDatabase();
    }
}
