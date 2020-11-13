package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;
import static org.junit.Assert.fail;

//import Steps.changeQtYmainItemSteep;

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
    public void checkQTY() throws InterruptedException {
        WebElement options = select;
        Select qty = new Select(options);
        WebElement gtyFirst = qty.getFirstSelectedOption();
        System.out.println("after selest qty is: " + gtyFirst.getText());

        String ActualQTY = gtyFirst.getText();
        System.out.println("Actual QTY main item= " + ActualQTY);
        String ExpectedQTY = "1";
        Assert.assertEquals(ExpectedQTY, ActualQTY);
    }

    public void checkSecondQTY() throws InterruptedException {
        String ActualQTY = secQTY.getText();
        System.out.println("Actual QTY second item = "+ActualQTY);
        String ExpectedQTY = "1";
        Assert.assertEquals(ExpectedQTY, ActualQTY);

    }

    public void changeQTYitem() throws InterruptedException {
        select.sendKeys("3");
        //select.sendKeys(Keys.ENTER);
        sleep(100);
        WebElement options = select;
        Select qty = new Select(options);
        WebElement gtyFirst = qty.getFirstSelectedOption();

        String ActualQTY = gtyFirst.getText();
        System.out.println("Actual QTY main item after change = "+ActualQTY);
        String ExpectedQTY = "3";
        Assert.assertEquals(ExpectedQTY, ActualQTY);
    }

    public void checkSecQTYchange() throws InterruptedException {
        String ActualQTY = secQTYchange.getText();
        System.out.println("Actual QTY second item after change = "+ActualQTY);
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
