package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    private WebDriver webDriver;
    private final String HOME_PAGE_BUTON = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]";
    public final String ADD_TO_CART = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]";
    public final String MODAL_HEADING_XPATH = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]";
    public final String MODAL_HEADING_TEXT = "Added!";
    public final String VIEW_CART_BUTON = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[2]/a[1]";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public WebElement getDress(int dressNumber) {
        if (dressNumber < 2 || dressNumber > 35) {
            throw new IllegalArgumentException(String.format("The dress number %d is not avaible", dressNumber));
        }
        return webDriver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[" + dressNumber + "]"));
    }

    public void clickOnHome() {
        WebElement home = webDriver.findElement(By.xpath(HOME_PAGE_BUTON));
        home.click();
    }

    public void scrollToDress(int dressNumber) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", getDress(dressNumber));
    }

    public void hoverToDrees(int dressNumber) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(getDress(dressNumber)).perform();
    }

    public void addedToCartButon() {
        WebElement addToCard = webDriver.findElement(By.xpath(ADD_TO_CART));
        addToCard.click();
    }

    public void elementFound() {
        boolean elementFound = new WebDriverWait(webDriver, Duration.ofSeconds(2))
                .until(ExpectedConditions.textToBe(By.xpath(MODAL_HEADING_XPATH), MODAL_HEADING_TEXT));
        WebElement addedText = webDriver.findElement(By.xpath(MODAL_HEADING_XPATH));
        String actualText = addedText.getText();
        Assert.assertEquals(actualText, MODAL_HEADING_TEXT);
    }

    public void clickViewCartButon() {
        WebElement viewCart = webDriver.findElement(By.xpath(VIEW_CART_BUTON));
        viewCart.click();
    }
}

