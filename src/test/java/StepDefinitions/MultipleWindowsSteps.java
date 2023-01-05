package StepDefinitions;

import POM.MultipleWindowsPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleWindowsSteps {

    MultipleWindowsPageElements multipleWindowsPageElements;
    @Given("User navigate to Open in New Tab page")
    public void userNavigateToOpenInNewTabPage() {
        multipleWindowsPageElements = new MultipleWindowsPageElements();
        multipleWindowsPageElements.validationMultipleWindowsPage();
    }

    @When("User clicks on the Click Here link")
    public void userClicksOnTheClickHereLink() {
        multipleWindowsPageElements = new MultipleWindowsPageElements();
        multipleWindowsPageElements.userClickOnTheClickHereLink();
    }

    @Then("User should see the New Window message")
    public void userShouldSeeTheNewWindowMessage() {
        multipleWindowsPageElements = new MultipleWindowsPageElements();
        multipleWindowsPageElements.newWindowSuccessfullyOpen();
    }
}
