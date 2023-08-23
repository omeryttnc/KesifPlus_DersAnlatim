package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WelcomePage extends CommonPage {
    @FindBy(css = ".userpanel-navigation-list-a span")
    public List<WebElement> sideBar;
}
