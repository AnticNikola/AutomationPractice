package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[8]/a[1]")
    private WebElement contactUsButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/input[1]")
    private WebElement placeHolderInputName;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[2]/input[1]")
    private WebElement placeHolderInputEmail;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[3]/input[1]")
    private WebElement inputSubject;
    @FindBy(id = "message")
    private WebElement inputMessageHere;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[6]/input[1]")
    private WebElement submitButton;
    public ContactUs(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void clickContactUs() {
        this.contactUsButton.click();
    }
    public void inputName(String value){
        this.placeHolderInputName.sendKeys(value);
    }
    public void inputEmail (String value){
        this.placeHolderInputEmail.sendKeys(value);
    }
    public void inputSubject(String value){
        this.inputSubject.sendKeys(value);
    }
    public void inputMesageHere(String value){
        this.inputMessageHere.sendKeys(value);
    }
    public void setContactUsButton(WebElement contactUsButton) {
        this.contactUsButton = contactUsButton;
    }
    public void clickSubmit(){
        this.submitButton.click();
    }
    public void pressEnter(){
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }
}
