package autotest.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SetUpTest {
        public static WebDriver driver;
        public static WebDriverWait wait;

        @BeforeClass
        public static void setUp(){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);
            driver.get("https://drive.google.com/");
        }

        @AfterClass
        public static void tearDown(){
            driver.quit();
        }
}


