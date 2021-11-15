import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.HarEntry;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LinksPage;

import java.net.Inet4Address;
import java.util.List;

public class ApiCallTest {

    static protected WebDriver driver;
    static protected BrowserUpProxyServer proxyServer;

    @BeforeAll
    public static void beforeClass(){
        proxyServer = new BrowserUpProxyServer(); // initializing the proxy server
        proxyServer.start(1882); // starting the proxy server
        proxyServer.enableHarCaptureTypes // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
                (CaptureType.REQUEST_HEADERS, CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        WebDriverManager.chromedriver().setup(); // setting up the driver
    }

    @BeforeEach
    public void beforeMethod(){
        Proxy proxy = new Proxy();

        try {  // added this code block because the browser throws connection refused error.
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            proxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
            proxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        ChromeOptions options = new ChromeOptions()
                .setProxy(proxy) // add proxy config to chrome options
                .setAcceptInsecureCerts(true) // to allow insecure certification
                .addArguments("--headless"); // for headless browser
        driver = new ChromeDriver(options);
        proxyServer.newHar("google.com"); //create a new HAR with the label "google.com"

    }


    @AfterAll
    public static void afterClass(){
        proxyServer.stop(); // stop the proxy server
        driver.quit(); // quit the driver
    }

    @Test
    @DisplayName("Created Api call")
    public void createdApiCallTest() throws InterruptedException {

        driver.get("https://demoqa.com/links");
        LinksPage linksPage = new LinksPage(driver);
        linksPage.clickCreated();
        Thread.sleep(100); // TODO: 15.11.2021 Need a better solution like waiting for the traffic to end ?

        List<HarEntry> harEntries = proxyServer.getHar().getLog().getEntries();
        HarEntry apiCall = null;


        for (HarEntry harEntry : harEntries){
            if (harEntry.getRequest().getUrl().contains("created")){
                apiCall = harEntry;
            }
        }

        assert apiCall != null;
        Assertions.assertEquals("201", String.valueOf(apiCall.getResponse().getStatus()), "Status code is not 201!");
        Assertions.assertEquals("https://demoqa.com/created", apiCall.getRequest().getUrl(), "Request url is not correct!");
        Assertions.assertEquals("GET", apiCall.getRequest().getMethod().toString() , "Http method is not GET!");

    }

    @Test
    @DisplayName("No content Api call")
    public void noContentApiCallTest() throws InterruptedException {

        driver.get("https://demoqa.com/links");
        LinksPage linksPage = new LinksPage(driver);
        linksPage.clickNoContent();
        Thread.sleep(100); // TODO: 15.11.2021 Need a better solution like waiting for the traffic to end ?

        List<HarEntry> harEntries = proxyServer.getHar().getLog().getEntries();
        HarEntry apiCall = null;

        for (HarEntry harEntry : harEntries){
            if (harEntry.getRequest().getUrl().contains("no-content")){
                apiCall = harEntry;
            }
        }

        assert apiCall != null;
        Assertions.assertEquals("204", String.valueOf(apiCall.getResponse().getStatus()), "Status code is not 201!");
        Assertions.assertEquals("https://demoqa.com/no-content", apiCall.getRequest().getUrl(), "Request url is not correct!");
        Assertions.assertEquals("GET", apiCall.getRequest().getMethod().toString() , "Http method is not GET!");

    }

}
