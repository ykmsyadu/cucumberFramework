package hooks;

import commons.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HooksSetUp extends BaseTest {

    public WebDriver driver;

//    public HooksSetUp(BaseTest base) throws IOException {
//        this.base = base;
//    }

    @Before
    public void launchBrowser() throws IOException {
        this.driver = initializeDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    @After
    public void  tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
