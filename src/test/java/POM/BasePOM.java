package POM;

import Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.time.Duration;

public class BasePOM {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));

    public void waitUntilVisibleAndClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitUntilVisibleOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilUrlTobe(){
        wait.until(ExpectedConditions.urlToBe("http://localhost:7080/windows/new"));

    }

    public void mouseActions(WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void mouseActionRightClick(WebElement element){

        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().build().perform();
    }

    public void dragAndDropMouseAction(WebElement element1,WebElement element2){
        Actions actions = new Actions(driver);

        Action action = actions.clickAndHold(element1).moveToElement(element2).release(element2).build();
        action.perform();
       // actions.clickAndHold(element2).moveToElement(element1).release(element1).build().perform();

    }



    public void successMessage(WebElement element) {
        String expectedResult = "\n" +
                "            You logged into a secure area!\n" +
                "            ";
        Assert.assertTrue(element.isDisplayed());
        Assert.assertTrue(element.getText().contains("You logged".toLowerCase()));
        Assert.assertEquals(expectedResult.toLowerCase(),element.getText().toLowerCase());

    }






}
