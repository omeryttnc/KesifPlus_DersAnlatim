package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConsultingPage extends CommonPage{
    // . -> class degeri
    // # -> id degeri

    @FindBy(xpath = "//a[contains(text(), 'Learn More')]")              public List<WebElement> learnMore;
    @FindBy(css = "#PageInfo-title")                                    public WebElement title;

}
