import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LinksPage;

import java.util.ArrayList;
import java.util.List;

public class LinksTest extends BaseTest {

    @Test
    @DisplayName("New tab is opened upon click home")
    public void newTabOpens(){
        LinksPage linksPage = new LinksPage(driver);
        driver.get("https://demoqa.com/links");
        linksPage.clickHome();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        Assertions.assertEquals(2, tabs.size(),"New tab ,s not opened!");

        driver.switchTo().window(tabs.get(1));

        Assertions.assertEquals("https://demoqa.com/",driver.getCurrentUrl(), "Current tab url is not correct!");

    }

}
