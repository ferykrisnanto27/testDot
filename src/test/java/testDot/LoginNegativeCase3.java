package testDot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginNegativeCase3 {
    @Test
    public void success_login_case() throws InterruptedException {
        WebDriver driver;
        String baseurl = "https://www.psegameshop.com/";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver set up
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

        //buka halaman login
        driver.findElement(By.cssSelector("a.nav-top-link.nav-top-not-logged-in.is-small[data-open='#login-form-popup']")).click();
        Thread.sleep(10000);
        //input email
        //Negative case 3 => Username/Email tidak terisi
        //input password
        driver.findElement(By.id("password")).sendKeys("PasswordBenar");
        //click login
        driver.findElement(By.cssSelector("button.woocommerce-button.button.woocommerce-form-login__submit[name='login'][value='Log in']")).click();
        Thread.sleep(10000);
        //cek ada warning gagal
        String errorWarning = driver.findElement(By.className("message-container")).getText();
        Assert.assertTrue(errorWarning.contains("Username is required."));
    }
}

