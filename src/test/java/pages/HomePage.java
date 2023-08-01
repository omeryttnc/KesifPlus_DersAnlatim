package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class HomePage extends CommonPage {

    @FindBy(css = "li a[href^='/']")
    public List<WebElement> navbarlist;

    @FindBy(css = "li a[href='/']")
    public WebElement homePageButton;

}


