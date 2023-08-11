package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US016 {
    @When("user clicks on Consulting page")
    public void userClicksOnConsultingPage() {
        commonPage.getHomePage().consulting.click();
    }

    @Then("user verifies {string} is visible")
    public void userVerifiesIsVisible(String title) {
        WebElement element = driver.findElement(By.xpath("//h4[text()='" + title + "']"));
        Assert.assertTrue(element.isDisplayed());
    }

    @When("user clicks on {string}")
    public void userClicksOn(String indexStr) {
        int index = Integer.parseInt(indexStr);
        commonPage.getConsultingPage().learnMore.get(index).click();
    }

    @Then("user verifies {string} is visible on relevant page")
    public void userVerifiesIsVisibleOnRelevantPage(String title) {
        Assert.assertEquals(title, commonPage.getConsultingPage().title.getText());
        Assert.assertTrue(commonPage.getConsultingPage().title.isDisplayed());
    }

    @And("user verifies the {string}")
    public void userVerifiesThe(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }


    @Then("user verifies relevant page is visible after clicking learn more")
    public void userVerifiesRelevantPageIsVisibleAfterClickingLearnMore(DataTable dataTable) {
        List<String> titles = dataTable.column(0);
        List<String> urls = dataTable.column(1);
        WebElement element;

        for (int i = 0; i < titles.size(); i++) {
            element = driver.findElement(By.xpath("//h4[text()='" + titles.get(i) + "']"));
            Assert.assertTrue(element.isDisplayed());

            commonPage.getConsultingPage().learnMore.get(i).click();

            Assert.assertTrue(commonPage.getConsultingPage().title.isDisplayed());
            Assert.assertEquals(titles.get(i), commonPage.getConsultingPage().title.getText());

            Assert.assertEquals(urls.get(i), driver.getCurrentUrl());

            driver.navigate().back();
        }

    }
}
