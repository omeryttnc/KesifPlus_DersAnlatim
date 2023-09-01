package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;

public class LoginPage extends CommonPage{
    @FindBy(css = "#email-uniq")                        public WebElement email;
    @FindBy(css = "#password-uniq")                     public WebElement password;
    @FindBy(css = ".mainButton-light-outlined")                     public WebElement loginButton;


    @FindBy(css = "#loginForm [type='submit']")
    public WebElement submit;

    public void login(String userEmail, String userPassword) {

        driver.get("http://kesifplus.com/login");
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        submit.click();

    }



}
