package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

public class RegisterPage extends CommonPage {
    @FindBy(id = "register-email-input")
    public WebElement email;

    @FindBy(id = "register-password-input")
    private WebElement password;

    @FindBy(id = "register-password-input-2")
    private WebElement password2;


    @FindBy(css = ".register-button [type='submit']")
    private WebElement submit;

    public void registerUser(String username, String userPassword) {
        email.flasWeblement();
        email.sendKeys(username);

        password.flasWeblement();
        password.sendKeys(userPassword);

        password2.flasWeblement();
        password2.sendKeys(userPassword);

        submit.flasWeblement();
        submit.click();
    }

    public void sendEmail(String userName) {
        email.sendKeys(userName);
    }


    public void clickSubmit() {
        submit.click();
    }

    public void assertEmailWarningText(String expectedWarning) {
        // way 1
        email.assertWarningText(expectedWarning);
        // way 2
        BrowserUtilities.assertWarningText(email, expectedWarning);

    }
}
