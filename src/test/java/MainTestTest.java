import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTestTest {
    static WebDriver driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("76.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver = new RemoteWebDriver(
                URI.create("http://selenoid:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void firstTest() throws InterruptedException {
        driver.get("https://yandex.ru");
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("123");
        Thread.sleep(50000);
        assertTrue(1==1,"Фартануло");
    }

    @Test
    public void secondTest() throws InterruptedException {
        assertTrue(1==1,"Фартануло");
    }
}
