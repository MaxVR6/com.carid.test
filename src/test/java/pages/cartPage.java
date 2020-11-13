package pages;

import Base.BaseUtil;
//import Steps.changeQtYmainItemSteep;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.fail;

public class cartPage {
    public cartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    @FindBy(how = How.CSS, using = ".cart_prod_name")
    public WebElement nameItemInCart;

    @FindBy(how = How.CSS, using = ".cart_prod_info")
    public WebElement text;

    @FindBy(how = How.CSS, using = ".cart-prod-quantity")
    public WebElement secQTY;

    @FindBy(how = How.CSS, using = ".form-field.-select>select")
    public WebElement select;

    @FindBy(how = How.CSS, using = ".cart-prod-quantity")
    public WebElement secQTYchange;

    @FindBy(how = How.CSS, using = ".icon-delete")
    public WebElement cnDelete;

    @FindBy(how = How.CSS, using = ".cart-item-remove-btn.-delete")
    public WebElement del;

    @FindBy(how = How.CSS, using = ".cart-empty-h1")
    public WebElement checkEmpty;

    public void check() throws InterruptedException {
        String nameInCart = nameItemInCart.getText();
        System.out.println(nameInCart);
        String nameItem = "Quality-Built® - Remanufactured Alternator";
        Assert.assertEquals(nameItem, nameInCart);
    }

    public void checkDescription() throws InterruptedException {
        String descr = text.getText();
        if(descr.contains("Dodge Ram 1999")){
            System.out.println("Dodge Ram 1999 is present in description");
        }
        else
        {
            fail(descr);
        }

    }

    public void checkSecondQTY() throws InterruptedException {
        String ActualQTY = secQTY.getText();
        System.out.println("Actual QTY = "+ActualQTY);
        String ExpectedQTY = "1";
        Assert.assertEquals(ExpectedQTY, ActualQTY);

    }

    public void changeQTYitem() throws InterruptedException {
        select.sendKeys("3");
    }

    public void checkSecQTYchange() throws InterruptedException {
        String ActualQTY = secQTYchange.getText();
        System.out.println("Actual QTY = "+ActualQTY);
        String ExpectedQTY = "3";
        Assert.assertEquals(ExpectedQTY, ActualQTY);
    }

    public void delete() throws InterruptedException {
        cnDelete.click();
        del.click();
    }

    public void checkEmptyCart() throws InterruptedException {

        String ActualEmpty = checkEmpty.getText();
        System.out.println("Actual QTY = "+ActualEmpty);
        String ExpectedEmpty = "Your Shopping Cart is Empty";
        Assert.assertEquals(ExpectedEmpty, ActualEmpty);
    }
}
