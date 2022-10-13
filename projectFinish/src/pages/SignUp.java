package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
    private WebDriver webDriver;

    @FindBy(id = "id_gender1")
    private WebElement title;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement days;

    @FindBy(id = "months")
    private WebElement months;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(id = "first_name")
    private WebElement firsName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipcode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]")
    private WebElement createAcount;


    public SignUp(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickOnTitle() {
        title.click();
    }

    public void inputName(String name) {
        this.name.sendKeys(name);
    }

    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void selectDays(String value) {
        Select dropdown = new Select(this.days);
        dropdown.selectByValue(value);
    }

    public void selectMonth(String value) {
        Select dropdown = new Select(this.months);
        dropdown.selectByVisibleText(value);
    }

    public void selectYear(String value) {
        Select dropdown = new Select(this.year);
        dropdown.selectByVisibleText(value);
    }

    public void inputFirstName(String value) {
        this.firsName.sendKeys(value);
    }

    public void inputLastName(String value) {
        this.lastName.sendKeys(value);
    }

    public void inputCompany(String value) {
        this.company.sendKeys(value);
    }
    public void inputAddress1(String value){
        this.address1.sendKeys(value);
    }
    public void inputCountry(String value){
        Select dropdown=new Select(country);
        dropdown.selectByVisibleText(value);
    }
    public void inputState(String value){
        this.state.sendKeys(value);
    }
    public void inputCity(String value){
        this.city.sendKeys(value);
    }
    public void inputZipCode(String value){
        this.zipcode.sendKeys(value);
    }
    public void inputMobileNumber(String value){
        this.mobileNumber.sendKeys(value);
    }
    public void clickCreateAcc(){
        this.createAcount.click();
    }
}

