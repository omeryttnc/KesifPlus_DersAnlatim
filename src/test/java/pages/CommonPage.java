package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;


public abstract class CommonPage {
    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;
    private LoginPage loginPage;
    private ConsultingPage consultingPage;
    private UserPanelPage userPanelPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public ConsultingPage getConsultingPage() {
        if (consultingPage == null)
            consultingPage =  new ConsultingPage();
        return consultingPage;
    }

    public UserPanelPage getUserPanelPage() {
        if(userPanelPage == null)
            userPanelPage = new UserPanelPage();
        return userPanelPage;
    }
}
