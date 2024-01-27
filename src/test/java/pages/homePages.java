package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePages {
    WebDriver driver;

    public homePages(WebDriver driver){
        this.driver=driver;
    }

    //Locator register button
    By RegisterLink = By.xpath("//*[@id='loginPanel']/p[2]/a");
    By RegisterLinkTest = By.xpath("//a[contains(@href,'register')]");

    //Method click register link button
    public void clickRegisterLink(){
        driver.findElement(RegisterLink).click();
    }


}
