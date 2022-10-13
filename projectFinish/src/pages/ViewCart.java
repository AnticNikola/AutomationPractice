package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCart {
    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]")
    private WebElement slika;

    public ViewCart(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(this.webDriver,this);
    }
    public String getFirstSrcAttr(){
        return slika.getAttribute("src");
    }
}

