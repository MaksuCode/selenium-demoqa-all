import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterMethod(){
        driver.close();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
