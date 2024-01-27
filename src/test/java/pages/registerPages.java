package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPages {
    WebDriver driver;

    public registerPages(WebDriver driver){
        this.driver=driver;
    }

    //Locator register button
    By RegisterButton = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    By RegisterButtonTest = By.xpath("//a[contains(@href,'register')]");

    //Method click register button
    public void clickRegisteButton(){
        driver.findElement(RegisterButton).click();
    }


}
