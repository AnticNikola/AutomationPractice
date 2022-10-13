package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DashBoard;
import pages.LogOut;

import java.time.Duration;

public class TestIncorrectPasswords {
    private WebDriver webDriver;
    private DashBoard dashBoard;
    private LogOut logOut;

    @BeforeMethod
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        dashBoard = new DashBoard(webDriver);
        logOut = new LogOut(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.get("https://www.automationexercise.com/login");
        webDriver.manage().window().maximize();
    }

    @DataProvider(name = "myDataProvider")
    public Object[][] createData1() {
        return new Object[][]{
                {"are@g.mail.com", "abrakadabra"},
                {"are@g.mail.com", "pokusaj68"},
                {"are@g.mail.com", "sifra9"},
                {"are@g.mail.com", "provala11"},
                {"are@g.mail.com", "upad13"}
        };
    }
    @Test(dataProvider="myDataProvider")
    public void testInvalidLogin(String email,String password){
        logOut.clickSignUpLogin();
        Assert.assertEquals(dashBoard.getLoginYourAccHeading(),"Login to your account","The mesage should be correct");
        logOut.inputEmailField(email);
        logOut.inputPasswordField(password);
        logOut.clicLoginButon();
        Assert.assertEquals(dashBoard.getIncorectLoginText(),"Your email or password is incorrect!","The mesage should be correct");
    }

    @AfterMethod
    public void closeWd(){
        webDriver.close();
    }
}
