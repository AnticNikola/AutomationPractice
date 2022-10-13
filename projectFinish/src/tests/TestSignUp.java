package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashBoard;
import pages.LoginNew;
import pages.SignUp;

import java.time.Duration;

public class TestSignUp {
    private WebDriver webDriver;
    private LoginNew loginNew;
    private SignUp signUp;
    private DashBoard dashBoard;


    @BeforeMethod
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginNew = new LoginNew(webDriver);
        signUp = new SignUp(webDriver);
        dashBoard=new DashBoard(webDriver);
        webDriver.get("https://www.automationexercise.com/login");
        webDriver.manage().window().maximize();
    }

    @Test
    public void testSingUp() {

        String name = Faker.instance().name().fullName();
        String email= Faker.instance().bothify("???##@yahoo.com");
        loginNew.inputNameField(name);
        loginNew.inputEmailField(email);
        loginNew.clicSignUpButon();
        signUp.clickOnTitle();
        signUp.inputName(name);
        signUp.inputPassword(Faker.instance().bothify("##?#?#?"));
        signUp.selectDays("9");
        signUp.selectMonth("January");
        signUp.selectYear("1984");
        signUp.inputFirstName("Nikola");
        signUp.inputLastName("Antic");
        signUp.inputCompany("ITbootcamp");
        signUp.inputAddress1("Vrtlarska 9");
        signUp.inputCountry("India");
        signUp.inputState("TadzMahal");
        signUp.inputCity("Zemun");
        signUp.inputZipCode("11070");
        signUp.inputMobileNumber("+3816548372394");
        Assert.assertEquals(dashBoard.getAccountCreatedHeadingText(),"ACCOUNT CREATED!","The mesage should be correct");

    }
    @AfterMethod
    public void closeWeb(){
        webDriver.close();

    }
}
