package stepDefinitions;


import enums.EnumCalismasi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pojos.Deneme;
import utilities.ConfigurationReader;
import utilities.DatabaseUtilities;
import utilities.Driver;


public class Hooks {
    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Deneme deneme;
    public static Actions actions;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {
        System.out.println("ui");

        driver = Driver.getDriver();
        deneme = new Deneme("omer", 5);
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @Before(order = 1, value = "@login")
    public void login() {
        System.out.println("login");

        driver.get("https://kesifplus.com/login");
        commonPage.getLoginPage().email.sendKeys(EnumCalismasi.DEMOKESIF.getEmail());
        commonPage.getLoginPage().password.sendKeys(EnumCalismasi.DEMOKESIF.getPassword());
        commonPage.getLoginPage().submit.click();
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }


    @Before("@MDB")
    public void setupMysqlDatabase() {
        DatabaseUtilities.createMysqlConnection();

    }

    @Before("@SDB")
    public void setupSqliteDatabase() {
        DatabaseUtilities.createSqliteConnection();

    }

    @After("@SDB")
    public void closeSqlieDatabase() {
        DatabaseUtilities.closeDatabase();
    }

    @After("@MDB")
    public void closeMySqlDatabase() {
        DatabaseUtilities.closeDatabase();
    }

    @Before(value = "@user1", order = 1)
    public void denemeLogin() {
        System.out.println(
                "email : " + ConfigurationReader.getProperty("user1_email") +
                        " password : " + ConfigurationReader.getProperty("user1_password")
        );


    }


    @Before(value = "@denemeSetup")
    public void denemeSetup() {
        System.out.println("deneme setup cagirildi");
    }


}
