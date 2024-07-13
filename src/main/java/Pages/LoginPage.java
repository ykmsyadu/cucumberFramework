package Pages;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;
import org.testng.Assert;
import java.io.IOException;

public class LoginPage extends BasePage {

    WebDriver driver;
    private By menu_SignIn,
               txt_uname,
               txt_pwd,
               btn_login;

    private By msg_errorlogin;

    String objRepoFile;
    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        objRepoFile = PropertyReader.getPropertyValue("src/test/resources/Config/File.properties","LoginPage");
        initElem();
    }

    public void initElem() throws IOException {
        menu_SignIn = PropertyReader.getLocator(objRepoFile,"menu_SignIn");
        txt_uname = PropertyReader.getLocator(objRepoFile,"txt_uname");
        txt_pwd = PropertyReader.getLocator(objRepoFile,"txt_pwd");
        btn_login = PropertyReader.getLocator(objRepoFile,"btn_login");

        msg_errorlogin = PropertyReader.getLocator(objRepoFile,"msg_errorlogin");
    }

    public LoginPage navigateToLogin() throws IOException {
        webDriverClick(menu_SignIn);
        return this;
    }

    public LoginPage performLogin(String uname, String pwd){
        enterKeys(txt_uname, uname);
        enterKeys(txt_pwd, pwd);
        webDriverClick(btn_login);
        return this;
    }

    public LoginPage verifyLoginTest(String username) throws IOException {
//        String loginText = waitForElement(By.xpath("//a[contains(text(),'"+username+"')]")).getText().trim();
//        Assert.assertEquals(loginText,"WELCOME, "+username.toUpperCase());
        Assert.fail();
        return this;
    }

    public LoginPage verifyInvalidLogin(String message) throws IOException {
        String errorMsg = waitForElement(msg_errorlogin).getText().trim();
        Assert.assertEquals(message,errorMsg);
        return this;
    }





}
