package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    private WebElement signUpLoginButon;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")
    private WebElement loginToAccEmail;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]")
    private WebElement loginToAccPassword;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]")
    private WebElement loginButonClick;

    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    private WebElement logOutButon;

    public LogOut(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(this.webDriver,this);
    }
    public void clickSignUpLogin(){
        signUpLoginButon.click();
    }
    public void inputEmailField(String value){
        loginToAccEmail.sendKeys(value);
    }
    public void inputPasswordField(String value){
        loginToAccPassword.sendKeys(value);
    }
    public void clicLoginButon(){
        loginButonClick.click();
    }
    public void clicLogOutButon(){
        logOutButon.click();
    }

}

