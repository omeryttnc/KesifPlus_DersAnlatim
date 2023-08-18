package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage{
    @FindBy(css = "#email-uniq")                        public WebElement email;
    @FindBy(css = "#password-uniq")                     public WebElement password;
    @FindBy(css = ".mainButton-light-outlined")                     public WebElement loginButton;

}
