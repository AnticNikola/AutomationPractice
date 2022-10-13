package tests;

import com.github.javafaker.Faker;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUs;
import pages.DashBoard;

import java.time.Duration;

public class TestContactUs {
    private WebDriver webDriver;

    private ContactUs contactUs;
    private DashBoard dashBoard;

    @BeforeMethod
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
        webDriver=new ChromeDriver();
        contactUs=new ContactUs(webDriver);
        dashBoard=new DashBoard(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.get("https://www.automationexercise.com/");
        webDriver.manage().window().maximize();
    }
    @Test
    public void testContactUs() {
        contactUs.clickContactUs();
        Assert.assertEquals(dashBoard.getTitleContactUs(),"CONTACT US","The mesage should be correct");
        contactUs.inputName(Faker.instance().name().firstName());
        contactUs.inputEmail(Faker.instance().internet().emailAddress());
        contactUs.inputSubject(Faker.instance().bothify("???????"));
        contactUs.inputMesageHere(Faker.instance().bothify("???????????"));
        contactUs.clickSubmit();
        contactUs.pressEnter();
        Assert.assertEquals(dashBoard.statusAlertMesage(),"Success! Your details have been submitted successfully.","The mesage should be correct");
    }
    @AfterMethod
    public void closeWd(){
        webDriver.close();
    }
}
