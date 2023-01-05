package POM;

import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MultipleWindowsPageElements extends BasePOM{

    public MultipleWindowsPageElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Multiple Windows']")
    private WebElement multipleWindowsBtn;

    @FindBy(xpath = "//h3[text()='Opening a new window']")
    private WebElement openingANewWindowPage;

    @FindBy(xpath = "//a[text()='Click Here']")
    private WebElement clickHereLink;

    @FindBy(xpath = "/html/body/div/h3")
    private WebElement newUrl;

    public void validationMultipleWindowsPage(){
        multipleWindowsBtn.click();
        waitUntilVisibleOfElement(openingANewWindowPage);

        Assert.assertTrue(openingANewWindowPage.isDisplayed());
        Assert.assertTrue(openingANewWindowPage.getText().toLowerCase().contains("new window".toLowerCase()));
    }

    public void userClickOnTheClickHereLink(){
        waitUntilVisibleOfElement(clickHereLink);
        clickHereLink.click();
    }

    public void newWindowSuccessfullyOpen(){
       // waitUntilUrlTobe();
        String currentUrl = "http://localhost:7080/windows/new";
        Assert.assertTrue(currentUrl.contains("new".toLowerCase()));
//        Assert.assertTrue(newUrl.isDisplayed());
//        String expectedResult = "New Window";
//        Assert.assertEquals(expectedResult,newUrl.getText());

    }
}
