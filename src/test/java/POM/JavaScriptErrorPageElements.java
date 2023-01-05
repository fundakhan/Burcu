package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPageElements extends BasePOM{


    public JavaScriptErrorPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Available Examples']")
    private WebElement homePage;
    @FindBy(xpath = "//a[text()='JavaScript onload event error']")
    private WebElement javaScriptErrorLink;

    @FindBy(xpath = "//body[@onload='loadError()']")
    WebElement errorMessage;

    public void navigateToHomePage(){
        Assert.assertTrue(homePage.isDisplayed());

    }
    public void userClickOnTheJavaScriptErrorLink(){

        javaScriptErrorLink.click();
    }
    public void validateJavaScriptErrorPage() {

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void validateErrorMessage() {

        String expectedErrorMessage = "\n" +
                "      This page has a JavaScript error in the onload event.\n" +
                "      This is often a problem to using normal Javascript injection\n" +
                "      techniques.\n" +
                "    ";
        Assert.assertTrue(errorMessage.isDisplayed());
      //  Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
        Assert.assertTrue(errorMessage.getText().toLowerCase().contains("This page has a JavaScript error in the onload event".toLowerCase()));

    }

}
