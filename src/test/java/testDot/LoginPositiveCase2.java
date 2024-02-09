package testDot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPositiveCase2 {
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
        //Positive case 2 => menggunakan username
        driver.findElement(By.id("username")).sendKeys("sekarinizhafira69");
        //input password
        driver.findElement(By.id("password")).sendKeys("SekariniZha1!");
        //click login
        driver.findElement(By.cssSelector("button.woocommerce-button.button.woocommerce-form-login__submit[name='login'][value='Log in']")).click();
        Thread.sleep(15000);
        //cek jika sudah berhasil masuk
        driver.findElement(By.cssSelector("a.account-link.account-login.is-small[title='My account']")).click();
        Thread.sleep(10000);
        //Assert label products di homepage
        String labelProducts = driver.findElement(By.className("user-name")).getText();
        Assert.assertEquals(labelProducts, "sekarinizhafira69");
    }
}

