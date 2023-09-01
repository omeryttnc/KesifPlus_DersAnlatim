package pages.PanelPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonPage;

import java.util.List;

public class ProfilePage extends CommonPage {
    @FindBy(css = ".card-3")                                                    public WebElement introductionCard;
    @FindBy(css = "#sidebar-profile")                                           public WebElement sidebarProfile;
    @FindBy(xpath = "//h1[text()='Introduce Yourself']")                        public WebElement introduceYourself;
    @FindBy(xpath = "//button[@class='update-button button-modify']")           public WebElement updateIntroduction;
    @FindBy(css = ".text-area")                                                 public WebElement introductionTextArea;
    @FindBy(css = ".save-button.button-modify")                                 public WebElement saveIntroduction;
    @FindBy(css = "p.note-content")                                             public WebElement introductionNote;
    @FindBy(css = ".delete-button")                                             public WebElement deleteButton;
    @FindBy(xpath = "//p")                                                      public List<WebElement> profilePTags;
}
