import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoMainTest {

    @Test
    public void test(){
        assertTrue(1==1);
    }    
    
    @Test
    public void testTwo() throws MalformedURLException, InterruptedException {
        WebDriver driver = null;
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            capabilities.setVersion("76.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--whitelisted-ips","--no-sandbox","--disable-extensions");
            driver = new RemoteWebDriver(
                    URI.create("http://selenoid:4444/wd/hub").toURL(),
                    capabilities
            );
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://mail.ru");
            assertTrue(1==1);
            Thread.sleep(50000);
        }finally {
            driver.quit();
        }

    }
}
