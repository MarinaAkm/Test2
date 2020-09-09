import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    @Test
    public void initWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Марина/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=500,500");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().setSize(new Dimension(200,100));
        driver.navigate().to("https://tt-develop.quality-lab.ru");
        driver.manage().window().maximize();
        driver.quit();
    }
}
