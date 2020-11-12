package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.itemPage;

import java.util.concurrent.TimeUnit;

public class itemStep extends BaseUtil {
    private BaseUtil base;

    public itemStep(BaseUtil base) {
        this.base = base;
        base.Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        base.Driver.manage().timeouts().pageLoadTimeout(3500, TimeUnit.SECONDS);
    }
    @Given("^I navigate to <item> and push to the add btn$")
    public void iNavigateToItemAndPushToTheAddBtn() throws Throwable{

        base.Driver.navigate().to(url);
        itemPage page = new itemPage(base.Driver);
        page.addBtn();
    }

    @And("^I select MMY$")
    public void iSelectMMY() throws Throwable {
        itemPage page = new itemPage(base.Driver);
        page.select();
    }

    @And("^I check correct MMY in pop-up$")
    public void iCheckCorrectMMYinPopUp() throws Throwable{
        itemPage page = new itemPage(base.Driver);
        page.check();
    }

    @And("^I go to cart by push to Checkout btn$")
    public void iGoToCartByPushToCheckoutBtn() throws InterruptedException {
        itemPage page = new itemPage(base.Driver);
        page.push();
    }
}
