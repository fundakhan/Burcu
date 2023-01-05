package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPageElements extends BasePOM{

    public DropdownPageElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Dropdown']")
    private WebElement dropdownButton;

    @FindBy(xpath = "//h3[text()='Dropdown List']")
    private WebElement dropdownPage;

    @FindBy(id = "dropdown")
    private WebElement selectBtn;

    @FindBy(css = "#dropdown > option:nth-child(2)")
    private WebElement option1;

    @FindBy(xpath = "//option[@selected='selected']/text()")
    private WebElement option1Selected;

    @FindBy(css = "#dropdown > option:nth-child(3)")
    private WebElement option2;

    @FindBy(xpath = "//option[@selected='selected']/text()")
    private WebElement option2Selected;

    public void userClickOnTheDropdownButton(){
        dropdownButton.click();
    }

    public void validationDropdownPage(){


        waitUntilVisibleOfElement(dropdownPage);
        Assert.assertTrue(dropdownPage.isDisplayed());
        Assert.assertTrue(dropdownPage.getText().toLowerCase().contains("Dropdown".toLowerCase()));
    }

    public void userSelectTheOption1(){

        Select select = new Select(selectBtn);
        select.selectByVisibleText("Option 1");

    }

    public void verifyTheOption1IsSelected(){

        waitUntilVisibleOfElement(option1Selected);
        Assert.assertTrue(option1Selected.isSelected());
    }

    public void userSelectTheOption2(){

        Select select = new Select(selectBtn);
        select.selectByVisibleText("Option 2");

    }

    public void verifyTheOption2IsSelected(){

        waitUntilVisibleOfElement(option2Selected);
        Assert.assertTrue(option2Selected.isSelected());
    }



}
