import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BrowserWindowsPage;

public class BrowserWindowsTest extends BaseTest{

    @Test
    @DisplayName("New tab opens after clicking 'New Tab' button")
    public void newTabTest(){
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage.clickNewTabButton();
        Assertions.assertEquals(2, browserWindowsPage.getTabs().size() , "New tab is not openedé");
        Assertions.assertEquals("https://demoqa.com/sample", browserWindowsPage.getNewTabUrl(), "New tab is not opened!");
    }

    @Test
    @DisplayName("New window opens after clicking 'New Tab' button")
    public void newWindowTest(){
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage.clickNewWindowButton();
        Assertions.assertEquals(2, browserWindowsPage.getTabs().size() , "New tab is not openedé");
        Assertions.assertEquals("https://demoqa.com/sample", browserWindowsPage.getNewTabUrl(), "New tab is not opened!");
    }

    @Test
    @DisplayName("Get message test")
    public void getNewWindowMessage(){
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage.clickMessageWindowButton();

        System.out.println(browserWindowsPage.getMessageOnNewWindow());
    }






}
