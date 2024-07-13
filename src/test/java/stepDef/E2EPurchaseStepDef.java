package stepDef;

import Pages.LoginPage;
import commons.BaseTest;
import hooks.HooksSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.HashMap;

public class E2EPurchaseStepDef extends BaseTest {

    WebDriver driver;
    LoginPage lp;
    HooksSetUp hook;
    ExcelUtils utils = new ExcelUtils();
    HashMap<String, String> data = new HashMap<>();
    private static final Logger log = LogManager.getLogger(E2EPurchaseStepDef.class);

    public E2EPurchaseStepDef(HooksSetUp hook) throws IOException {
        this.hook = hook;
        this.driver = hook.getDriver();
        data = utils.getData("TestData","TestData",1,data);

    }

    @Given("User selects login option")
    public void user_selects_login() throws Exception{
        lp = new LoginPage(driver).navigateToLogin();
    }

    @When("Login to the ecommerce application using username {string} and password {string}")
    public void login_to_the_ecommerce_application_using_username_and_password(String uname, String pwd) {
        lp.performLogin(uname, pwd);
    }

    @Then("Verify login profile")
    public void verifyLoginProfile() throws Exception {
        lp.verifyLoginTest("YADUKRISHNA");
    }

    @Then("Verify error message {string}")
    public void verifyInvalidLogin(String message) throws IOException {
        lp.verifyInvalidLogin(message);
    }

}
