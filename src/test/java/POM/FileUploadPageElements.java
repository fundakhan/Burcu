package POM;

import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FileUploadPageElements extends BasePOM{

    public FileUploadPageElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='File Upload']")
    private WebElement fileUploadBtn;

    @FindBy(xpath = "//h3[text()='File Uploader']")
    private WebElement fileUploadPage;

    @FindBy(id = "file-upload")
    private WebElement chooseFileBtn;

    @FindBy(id = "file-submit")
    private WebElement uploadBtn;

    @FindBy(xpath = "//*[@id='uploaded-files']/text()")
    private WebElement successMessage;

    @FindBy(id = "drag-drop-upload")
    private WebElement dragAndDropBox;

    @FindBy(xpath = "//*[@id=\"drag-drop-upload\"]/div/div[1]/div/span")
    private WebElement textInBox;

    public void clickFileUploadButton(){
        fileUploadBtn.click();

    }
    public void validationFileUploaderPage(){

        waitUntilVisibleOfElement(fileUploadPage);

        Assert.assertTrue(fileUploadPage.isDisplayed());
        Assert.assertTrue(fileUploadPage.getText().toLowerCase().contains("Uploader".toLowerCase()));
    }

    public void userSelectFile() throws AWTException {
        waitUntilVisibleOfElement(chooseFileBtn);
        mouseActions(chooseFileBtn);
//        Robot robot = new Robot();
//        robot.mousePress();
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
        StringSelection stringSelection = new StringSelection("C:\\Users\\funda\\Downloads");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        Robot robot1 = new Robot();
     //   robot1.mouseMove(100,200);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //put path to your image in a clipboard
        String filePath = "C:\\Users\\funda\\Downloads\\some-file.txt";
        StringSelection ss = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(ss,null);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        wait.until(ExpectedConditions.titleIs("C:\\Users\\funda\\Downloads\\some-file.txt"));
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void userClickOnTheUploadButton(){

        uploadBtn.click();
    }

    public void fileSuccessfullyUploaded(){

        waitUntilVisibleOfElement(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().toLowerCase().contains("Uploaded!".toLowerCase()));
    }

    public void dragAndDropTheFile() throws AWTException {
        waitUntilVisibleAndClickable(chooseFileBtn);
        String filePath = "C:\\Users\\funda\\Downloads\\some-file (13).txt";
        StringSelection ss = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(ss,null);

        Robot robot = new Robot();
        // Move the mouse to the starting position for the drag
        robot.mouseMove(100, 100);
        // Press the mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        // Drag the mouse to the destination position
        robot.mouseMove(200, 200);

        // Release the mouse button to drop the item
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }



}
