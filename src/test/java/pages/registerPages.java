package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPages {
    WebDriver driver;

    public registerPages(WebDriver driver){
        this.driver=driver;
    }

    //Locator register button
    By firstnameField = By.xpath("//*[@id='customer.firstName']");
    By lastnameField = By.xpath("//*[@id='customer.lastName']");

    //Method click register button
    public void inputNameData(String firstname, String lastname){
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
    }


}
