package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DragAndDropPageElements extends BasePOM{

    public DragAndDropPageElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Drag and Drop']")
    private WebElement dragAndDropButton;

    @FindBy(xpath = "//h3[text()='Drag and Drop']")
    private WebElement dragAndDropPage;

    @FindBy(id = "column-a")
    private WebElement boxA;

    @FindBy(id = "column-b")
    private WebElement boxB;

    @FindBy(xpath = "//header[text()='A']")
    private WebElement headerA;

    @FindBy(xpath = "//header[text()='B']")
    private WebElement headerB;

    public void validationDragAndDropPage(){

        dragAndDropButton.click();
        waitUntilVisibleOfElement(dragAndDropPage);
        Assert.assertTrue(dragAndDropPage.isDisplayed());
        Assert.assertTrue(dragAndDropPage.getText().toLowerCase().contains("Drag".toLowerCase()));
    }

    public void userDragAndDropBoxAAndB() throws AWTException {

        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[text()='A']")));
        actions.clickAndHold(headerA).moveToElement(headerB).release(headerB).build().perform();
//        Action action = actions.dragAndDrop(boxA,boxB).release(boxB).build();
//        action.perform();
     //   actions.dragAndDrop(boxA,boxB).release(boxB).build().perform();
     //   actions.dragAndDrop(boxA, boxB).perform();






        Robot robot = new Robot ();
        // Move the mouse to the draggable element and press the left mouse button
//        robot.mouseMove(headerA.getLocation().x=100, headerA.getLocation().y=100);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//
//        // Move the mouse to the dropzone and release the left mouse button
//        robot.mouseMove(headerB.getLocation().x, headerB.getLocation().y);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);




    }



    public void successfullySwitchedBoxAAndB(){
        waitUntilVisibleOfElement(headerA);
        waitUntilVisibleOfElement(headerB);
        String expectedHeaderA = "A";
        String expectedHeaderB = "B";
        Assert.assertTrue(headerA.isDisplayed());
        Assert.assertEquals(expectedHeaderA,headerB.getText());
        Assert.assertTrue(headerB.isDisplayed());
        Assert.assertEquals(expectedHeaderB,headerA.getText());

    }


}
