package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        Action action = actions.dragAndDrop(boxA,boxB).release(boxB).build();
        action.perform();
     //   actions.dragAndDrop(boxA,boxB).release(boxB).build().perform();
        //actions.dragAndDrop(boxA, boxB).build().perform();
      //  Robot robot = new Robot ();
//        robot.mouseMove(350, 226);
//        robot.keyPress(InputEvent.BUTTON1_MASK);
//        robot.mouseMove(250, 350);
//        robot.keyRelease(InputEvent.BUTTON1_MASK);

//        robot.mousePress(InputEvent.BUTTON1_MASK);
//        robot.mouseMove(20,50);
//        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void successfullySwitchedBoxAAndB(){
        waitUntilVisibleOfElement(headerA);
        waitUntilVisibleOfElement(headerB);
        Assert.assertEquals(boxA.getText(), headerB.getText());
        Assert.assertEquals(boxB.getText(), headerA.getText());

    }


}
