package testDot.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class testLoginPSE {
    WebDriver driver;
    String baseurl = "https://www.psegameshop.com/";

    @Given("User launch the website")
    public void user_launch_the_website() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // apply chrome driver set up
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

        //buka halaman login
        driver.findElement(By.cssSelector("a.nav-top-link.nav-top-not-logged-in.is-small[data-open='#login-form-popup']")).click();
        Thread.sleep(10000);
    }

    @And("User input registered email")
    public void user_input_registered_email() {
        //input email
        driver.findElement(By.id("username")).sendKeys("sekarinizhafira69@gmail.com");
    }

    @And("User input valid password")
    public void user_input_valid_password() {
        //input password
        driver.findElement(By.id("password")).sendKeys("SekariniZha1!");
    }

    @And("User input registered username")
    public void user_input_registered_username() {
        //input password
        driver.findElement(By.id("username")).sendKeys("sekarinizhafira69");
    }

    @When("User click login button")
    public void user_click_login_button() throws InterruptedException {
        //click login
        driver.findElement(By.cssSelector("button.woocommerce-button.button.woocommerce-form-login__submit[name='login'][value='Log in']")).click();
        Thread.sleep(10000);
    }

    @Then("Screen redirected to main page")
    public void screen_redirected_to_main_page() throws InterruptedException {
        //cek jika sudah berhasil masuk
        driver.findElement(By.cssSelector("a.account-link.account-login.is-small[title='My account']")).click();
        Thread.sleep(15000);
        //Assert label products di homepage
        String labelProducts = driver.findElement(By.className("user-name")).getText();
        Assert.assertEquals(labelProducts, "sekarinizhafira69");
        driver.quit();
    }

    @And("User input wrong password")
    public void user_input_wrong_password(){
        //input password
        //Negative case 1 => username benar, password salah
        driver.findElement(By.id("password")).sendKeys("PasswordSalah");
    }

    @Then("Error password incorrect")
    public void error_password_incorrect(){
        //cek ada warning gagal
        //Assert label products di homepage
        String errorWarning = driver.findElement(By.className("message-container")).getText();
        Assert.assertTrue(errorWarning.contains("incorrect"));
        driver.quit();
    }

    @And("User input unregistered email")
    public void user_input_unregistered_email(){
        //input email
        //Negative case 2 => Username tidak terdaftar
        driver.findElement(By.id("username")).sendKeys("sekarinizhafira@gmail.com");
    }

    @And("User input any password")
    public void user_input_any_password(){
        //input password
        driver.findElement(By.id("password")).sendKeys("PasswordBenar");
    }

    @Then("Error email unknown")
    public void error_email_unknown(){
        //cek ada warning gagal
        String errorWarning = driver.findElement(By.className("message-container")).getText();
        Assert.assertTrue(errorWarning.contains("Unknown email address"));
        driver.quit();
    }

    @Then("Error email required")
    public void error_email_required(){
        //cek ada warning gagal
        String errorWarning = driver.findElement(By.className("message-container")).getText();
        Assert.assertTrue(errorWarning.contains("Username is required."));
        driver.quit();
    }

    @Then("Error password empty")
    public void error_password_empty(){
        //cek ada warning gagal
        String errorWarning = driver.findElement(By.className("message-container")).getText();
        Assert.assertTrue(errorWarning.contains("The password field is empty."));
        driver.quit();
    }
}




