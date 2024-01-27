package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.homePages;
import pages.registerPages;

import java.time.Duration;
import java.util.Random;

public class MyStepdefs extends env_target{
    @Given ("^User is on parabank homepage$")
    public void userIsOnParabankHomepage() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(parabankLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']"))
        );
    }

    @When("^User click Register button$")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
        // homePages registerPages = new homePages(driver);
        // registerPages.clickRegister();
    }

    @When("^User is in register page$")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/p"))
        );

    }

    @Then("^User input name$")
    public void userInputName() {
        //User input first name
        //driver.findElement(By.xpath("//*[@id='customer.firstName']")).sendKeys("Myskill");
        //User input last name
        //driver.findElement(By.xpath("//*[@id='customer.lastName']")).sendKeys("indo");

        registerPages registerPages = new registerPages(driver);
        registerPages.inputNameData("MySkill","Indo");
    }

    @And("^User input address detail$")
    public void userInputAddressDetail() {
        //User input Address
        driver.findElement(By.id("customer.address.street")).sendKeys("Sweet Home");
        //User input City
        driver.findElement(By.id("customer.address.city")).sendKeys("Kota");
        //User input State
        driver.findElement(By.id("customer.address.state")).sendKeys("Negara");
        //User input ZipCode
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("112321");
        //User input Phone #
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123873431");
        //User input SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("158843458");

    }

    @And("^User fill valid username and password$")
    public void userFillValidUsernameAndPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        //Input username
        driver.findElement(By.id("customer.username")).sendKeys("user"+userRand);
        //Input password
        driver.findElement(By.id("customer.password")).sendKeys("12345");
    }

    @And("^User input password confirmation$")
    public void userInputPasswordConfirmation() {
        //Input confirm password
        driver.findElement(By.id("repeatedPassword")).sendKeys("12345");
    }

    @When("^User click register link button$")
    public void userClickRegisterLinkButton() {
        //driver.findElement(By.xpath("html body div#mainPanel div#bodyPanel div#rightPanel form#customerForm table.form2 tbody tr td input.button")).click();
        //driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();
        homePages homePages = new homePages(driver);
        homePages.clickRegisterLink();

    }

    @Then("user regist successfully")
    public void userRegistSuccessfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/p"))
        );
        driver.quit();
    }

    @And("^User input invalid password confirmation$")
    public void userInputInvalidPasswordConfirmation() {
        //Input invalid password
        driver.findElement(By.id("repeatedPassword")).sendKeys("1");
    }

    @Then("^user get error password did not match$")
    public void userGetErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"repeatedPassword.errors\"]"))
        );
        driver.quit();
    }


    @When("user click Register buttons")
    public void userClickRegisterButtons() {
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
        //homePages homePages = new homePages(driver);
        //homePages.clickRegister();
    }
}
