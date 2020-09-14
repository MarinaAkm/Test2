import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginTest {
    public ChromeDriver driver;

    @BeforeEach
    public void initWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        new ChromeOptions().addArguments("--window-size=500,500");
        driver.manage().window().setSize(new Dimension(200, 100));
        driver.navigate().to("https://tt-develop.quality-lab.ru");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void close(){
        driver.quit();
    }

    @Test
    public void incorrectUserNameAndPassword(){
        By elementLocator = By.xpath("//*[contains(text(), 'Invalid credentials')]");
        driver.findElement(By.cssSelector("[name=\"_username\"]")).sendKeys("TestUser");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("Password");
        try {
            driver.findElement(elementLocator);
            fail();
        }catch (NoSuchElementException ignored){}
        driver.findElement(By.cssSelector("[value='Войти']")).click();
        driver.findElement(elementLocator);
    }
}
