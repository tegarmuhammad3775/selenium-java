package stepDefLogin;
import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginBdd extends env_target{
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        //set driver location path
        System.setProperty("webDriver.chrome.drive","src/main/resources/drivers/chromedriver.exe");
        //maximaze driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-button\"]"))
        );
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory_filter_container\"]/div"))
        );
        driver.quit();
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
        driver.quit();
    }

    @When("User fill wrong username and password")
    public void userFillWrongUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("wrong_username");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("^User input (.*) and (.*)$")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User get verify login (.*)$")
    public void userGetVerifyLoginResult(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result.equals("Passed")){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory_filter_container\"]/div"))
            );
        }else if(result.equals("Failed")){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
            );
        }
        driver.quit();
    }
}
