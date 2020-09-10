import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginTest {
    public ChromeDriver driver;

    @BeforeEach
    public void initWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=500,500");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().setSize(new Dimension(200, 100));
        driver.navigate().to("https://tt-develop.quality-lab.ru");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void close(){
        driver.quit();
    }

    @Test
    public void incorrectUserNameAndPassword(){
        By elementLocator = By.xpath("//*[contains(text(), 'Invalid credentials')]");
        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("TestUser");
        driver.findElement(By.cssSelector("#password")).sendKeys("Password");
        try {
            driver.findElement(elementLocator);
            fail();
        }catch (NoSuchElementException ignored){}
        driver.findElement(By.cssSelector("[value='Войти']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(elementLocator);
    }
}
