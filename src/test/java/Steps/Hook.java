package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void before()
    {
        System.setProperty("webdriver.chrome.driver", "/media/hdd2_1TB/IntellejIdeaProject/com.carid.test/chromedriver");
        System.setProperty("webdriver.Firefox.driver", "/media/hdd2_1TB/IntellejIdeaProject/com.carid.test/geckodriver");
        base.Driver = new ChromeDriver();
        //base.Driver = new FirefoxDriver();
        base.Driver.manage().window().maximize();

    }

    @After
    public void after(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            System.out.println(scenario.getName());
        }
        System.out.println("Close the browser");
    }
}
