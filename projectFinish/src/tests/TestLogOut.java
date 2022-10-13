package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashBoard;
import pages.LogOut;

import java.time.Duration;

public class TestLogOut {
    private WebDriver webDriver;

    private DashBoard dashBoard;

    private LogOut logOut;

    @BeforeMethod
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        dashBoard = new DashBoard(webDriver);
        logOut = new LogOut(webDriver);
        webDriver.get("https://www.automationexercise.com/");
        webDriver.manage().window().maximize();
    }
    @Test
    public void testLoginLogOut(){

        logOut.clickSignUpLogin();
        Assert.assertEquals(dashBoard.getLoginYourAccHeading(),"Login to your account","The mesage should be correct");
        logOut.inputEmailField("stokos_blokos@yahoo.com");
        logOut.inputPasswordField("123");
        logOut.clicLoginButon();
        Assert.assertEquals(dashBoard.getLogedInAs(),"Dzontra Antic","the mesage should be correct");
        logOut.clicLogOutButon();
    }
    @AfterMethod
    public void closeWd(){
        webDriver.close();
    }
}

