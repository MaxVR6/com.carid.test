package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cartPage;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.support.ui.Select;

public class cartStep extends BaseUtil{
    private BaseUtil base;

    public cartStep(BaseUtil base) {
        this.base = base;
        base.Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        base.Driver.manage().timeouts().pageLoadTimeout(3500, TimeUnit.SECONDS);
    }

    @And("^I check item in cart$")
    public void iCheckItemInCart() throws InterruptedException {
        cartPage page = new cartPage(base.Driver);
        page.check();
    }

    @And("^I check present MMY in description$")
    public void iCheckPresentMMYInDescription() throws Throwable{
        cartPage page = new cartPage(base.Driver);
        page.checkDescription();


    }

    @And("^I check QTY main item in cart$")
    public void iCheckQTYMainItemInCart() throws InterruptedException {
        cartPage page = new cartPage(base.Driver);
        page.checkQTY();
//        WebElement options = base.Driver.findElement(By.xpath("//*[@id=\"scrollfix\"]/div/div/main/div[3]/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div/select"));
//        Select qty = new Select(options);
//        WebElement gtyFirst = qty.getFirstSelectedOption();
//        System.out.println("after selest qty is: " +gtyFirst.getText());
//
//        String ActualQTY = gtyFirst.getText();
//        System.out.println("Actual QTY main item= "+ActualQTY);
//        String ExpectedQTY = "1";
//        Assert.assertEquals(ExpectedQTY, ActualQTY);
    }

    @Then("^I check QTY second item in cart$")
    public void iCheckQTYSecondItemInCart() throws InterruptedException {
        cartPage page = new cartPage(base.Driver);
        page.checkSecondQTY();

    }

    @And("^I change QTY main item in cart$")
    public void iChangeQTYMainItemInCart() throws InterruptedException {
        cartPage page = new cartPage(base.Driver);
        page.changeQTYitem();
    }

    @And("^I check QTY second item in cart after change QTY main item$")
    public void iCheckQTYSecondItemInCartAfterChangeQTYMainItem() throws InterruptedException {
        WebElement explicitWait = (new WebDriverWait(base.Driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"scrollfix\"]//form/div[2]/div[3]")));
        explicitWait.click();
        cartPage page = new cartPage(base.Driver);
        page.checkSecQTYchange();
    }

    @And("^I delete main item from cart$")
    public void iDeleteMainItemFromCart() throws InterruptedException {
        cartPage page = new cartPage(base.Driver);
        page.delete();
    }

    @Then("^I check cart is empty$")
    public void iCheckCartIsEmpty() throws InterruptedException {
        cartPage page = new cartPage(base.Driver);
        page.checkEmptyCart();
    }
}
