package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertPageElements extends BasePOM{


    public void JavaScriptPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/javascript_alerts']/../../..")
    private WebElement javaScriptAlertsLink;

    @FindBy(xpath = "//h3[text()='JavaScript Alerts']")
    private WebElement JavaScriptAlertsPage;

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement JSAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement JSConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement JSPromptButton;

    @FindBy(xpath = "//p[@id='result']")
    private WebElement SuccessMessage;

    public void validationJavaScriptAlertPage() {

        javaScriptAlertsLink.click();
        waitUntilVisibleOfElement(JavaScriptAlertsPage);
        Assert.assertTrue(JavaScriptAlertsPage.isDisplayed());
        Assert.assertTrue(JavaScriptAlertsPage.getText().toLowerCase().contains("JavaScript".toLowerCase()));

    }

    public void userClickTheJSAlertButton() {
        JSAlertButton.click();

    }

    public void userHandleTheJSAlert() {
        //driver.switchTo().alert().getText().contains("I am a JS Alert");
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Assert.assertTrue(SuccessMessage.isDisplayed());
        Assert.assertTrue(SuccessMessage.getText().toLowerCase().contains("successfully".toLowerCase()));
        String expectedSuccessMessage= "You successfully clicked an alert";
        Assert.assertEquals(SuccessMessage.getText(), expectedSuccessMessage);

    }

    public void userClickTheJSConfirmButton() {
        JSConfirmButton.click();
    }

    public void userHandleTheJSConfirm() {
        //driver.switchTo().alert().getText().contains("I am a JS Confirm");
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
        Assert.assertTrue(SuccessMessage.isDisplayed());
        Assert.assertTrue(SuccessMessage.getText().toLowerCase().contains("clicked".toLowerCase()));

    }

    public void userClickTheJSPromptButton() {
        JSPromptButton.click();
    }

    public void userHandleTheJSPrompt(String text) {
        //driver.switchTo().alert().getText().contains("I am a JS prompt");
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Assert.assertTrue(SuccessMessage.isDisplayed());
        Assert.assertTrue(SuccessMessage.getText().toLowerCase().contains("entered".toLowerCase()));

    }

}
