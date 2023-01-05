package StepDefinitions;

import POM.JavaScriptErrorPageElements;
import io.cucumber.java.en.*;

public class JavaScriptErrorSteps {

    JavaScriptErrorPageElements javaScriptErrorPageElements;

    @Given("User Navigate to Home Page")
    public void userNavigateToHomePage() {
        javaScriptErrorPageElements = new JavaScriptErrorPageElements();
        javaScriptErrorPageElements.navigateToHomePage();
    }


    @When("User clicks to the JavaScript Error link")
    public void userClicksToTheJavaScriptErrorLink() {
        javaScriptErrorPageElements = new JavaScriptErrorPageElements();
        javaScriptErrorPageElements.userClickOnTheJavaScriptErrorLink();
    }
    @Then("User navigate to JavaScript Error page")
    public void userNavigateToJavaScriptErrorPage() {
        javaScriptErrorPageElements = new JavaScriptErrorPageElements();
        javaScriptErrorPageElements.validateJavaScriptErrorPage();

    }

    @Then("User should see the error message")
    public void userShouldSeeTheErrorMessage() {
        javaScriptErrorPageElements = new JavaScriptErrorPageElements();
        javaScriptErrorPageElements.validateErrorMessage();

    }


}
