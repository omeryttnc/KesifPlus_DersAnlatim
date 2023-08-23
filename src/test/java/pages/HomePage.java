package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class HomePage extends CommonPage {

    @FindBy(css = "li a[href^='/']")
    public List<WebElement> navbarlist;

    @FindBy(css = "li a[href='/']")
    public WebElement homePageButton;

    @FindBy(css = "div.package1 button")
    public WebElement silver_getStarted;


    @FindBy(css = "div.package2 button")
    public WebElement gold_getStarted;


    @FindBy(css = "div.package3 button")
    public WebElement platin_getStarted;

    @FindBy(css = "h4.pricing-h4")
    public WebElement planAndPricingText;

    //css -> li > a[href='/consulting']: / in xpath
    //css -> li a[href='/consulting']: // in xpath
    @FindBy(xpath = "//a[text()='Consulting']")
    public WebElement consulting;


}


