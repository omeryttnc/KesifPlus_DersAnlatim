package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPanelPage extends CommonPage {
    @FindBy(css = "#userpanel-sidebar")                                     public WebElement sidebar;
    @FindBy(css = ".fa-solid.fa-angle-left.sidebar-res")                    public WebElement leftArrow;
}
