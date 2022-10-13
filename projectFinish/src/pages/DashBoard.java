package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/h2[1]/b[1]")
    private WebElement accountCreatedHeading;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/h2[1]")
    private WebElement loginToYourAccHeading;

    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]/b[1]")
    private WebElement logedInAs;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]")
    private WebElement incorectEmailOrPasswordText;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/h2[1]")
    private WebElement titleContactUs;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]")
    private WebElement statusAlert;

    public DashBoard(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public String getAccountCreatedHeadingText() {
        return accountCreatedHeading.getText();
    }

    public String getLoginYourAccHeading() {
        return loginToYourAccHeading.getText();
    }

    public String getLogedInAs() {
        return logedInAs.getText();
    }

    public String getIncorectLoginText() {
        return incorectEmailOrPasswordText.getText();
    }

    public String getTitleContactUs() {
        return titleContactUs.getText();
    }

    public String statusAlertMesage() {
        return statusAlert.getText();
    }
}

