package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.cartPage;

import java.util.concurrent.TimeUnit;

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
//*[@id="scrollfix"]/div/div/main/div[3]/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div/select/option[8]

        WebElement select = base.Driver.findElement(By.cssSelector(".form-field.-select>select"));
        String activSelect = select.getAttribute("option selected value");
        String activSelect2 = select.getTagName();
        System.out.println("active: "+ activSelect);
        System.out.println("active: "+ activSelect2);

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
