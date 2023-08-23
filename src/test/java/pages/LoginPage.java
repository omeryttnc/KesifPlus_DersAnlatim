package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;

public class LoginPage extends CommonPage {

    @FindBy(id = "email-uniq")
    private WebElement email;


    @FindBy(id = "password-uniq")
    private WebElement password;

    @FindBy(css = "#loginForm [type='submit']")
    private WebElement submit;

    public void login(String userEmail, String userPassword) {

        driver.get("http://kesifplus.com/login");
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        submit.click();

    }


}
