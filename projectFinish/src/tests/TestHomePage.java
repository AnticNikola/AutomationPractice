package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ViewCart;

public class TestHomePage {
    private WebDriver webDriver;
    private HomePage homePage;
    private ViewCart viewCart;

    @BeforeMethod
    public void configure(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        homePage  = new HomePage(webDriver);
        viewCart  = new ViewCart(webDriver);
        webDriver.get("https://www.automationexercise.com/");
        webDriver.manage().window().maximize();
    }
    @Test
    public void addToShoping() {
        homePage.clickOnHome();
        homePage.scrollToDress(2);
        homePage.hoverToDrees(2);
        homePage.addedToCartButon();
        homePage.elementFound();
        homePage.clickViewCartButon();
        Assert.assertEquals(viewCart.getFirstSrcAttr(),"https://www.automationexercise.com/get_product_picture/1", "the url should be 'get_product_picture/1'");
    }
    @AfterMethod
    public void closeWebDriver(){
        webDriver.close();
    }
}


