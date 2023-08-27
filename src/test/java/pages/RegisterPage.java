package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.databaseStepDef.databaseRegisterTest.faker;

public class RegisterPage extends CommonPage {
    @FindBy(id = "register-email-input")
    public WebElement email;

    @FindBy(id = "register-password-input")
    public WebElement password;

    @FindBy(id = "register-password-input-2")
    public WebElement password2;


    @FindBy(css = ".register-button [type='submit']")
    public WebElement submit;

    public void registerUser(String username, String userPassword) {
//        email.flasWeblement();
        email.sendKeys(username);

//        password.flasWeblement();
        password.sendKeys(userPassword);

//        password2.flasWeblement();
        password2.sendKeys(userPassword);

//        submit.flasWeblement();
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
//        email.assertWarningText(expectedWarning);
        // way 2
        BrowserUtilities.assertWarningText(email, expectedWarning);

    }

    public String register() {
        String password = faker.internet().password(8, 16, true, true, true);
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        password2.sendKeys(password);

        commonPage.getRegisterPage().submit.click();

        return email;
    }
}
