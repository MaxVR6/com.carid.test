package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class itemPage {
    public itemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    @FindBy(how = How.ID, using = "addToCartButReact")
    public WebElement addBtn2;

    @FindBy(how = How.CSS, using = ".prod-title>.name")
    public WebElement nameItem;

    @FindBy(how = How.CSS, using = ".po-select")
    public WebElement garageSelectorMMYcss;

    @FindBy(how = How.XPATH, using = "*//ul/li[text()='1999']")
    public WebElement selectYear;

    @FindBy(how = How.XPATH, using = "*//ul/li[text()='Dodge']")
    public WebElement selectMark;

    @FindBy(how = How.XPATH, using = "*//ul/li[text()='Ram']")
    public WebElement selectModel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mainOpts\"]/div[3]/div/div[1]/div")
    public WebElement checkMMY;

    @FindBy(how = How.XPATH, using = "//*[text()='Add To Cart']")
    public WebElement clickBtnAddToCart;

    @FindBy(how = How.XPATH, using = "//*[text()='Checkout']")
    public WebElement clickBtnCheckout;

    public void addBtn() throws InterruptedException {
        addBtn2.click();
        //String name = nameItem.getText();
    }

    public void select() throws InterruptedException {
        garageSelectorMMYcss.click();
        selectYear.click();
        selectMark.click();
        selectModel.click();
    }

    public void check() throws InterruptedException {
        String ActualMMY = checkMMY.getText();
        System.out.println(ActualMMY);
        String ExpectedMMY = "1999 Dodge Ram";
        Assert.assertEquals(ExpectedMMY, ActualMMY);
        clickBtnAddToCart.click();
    }

    public void push() throws InterruptedException {
        clickBtnCheckout.click();
    }
}
