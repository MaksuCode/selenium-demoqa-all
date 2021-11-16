import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DynamicElementsPage;

public class DynamicElementsTest extends BaseTest{


    @Test
    @DisplayName("Button is not enabled for 5 seconds")
    public void disabledButtonTest(){
        DynamicElementsPage dynamicElementsPage = new DynamicElementsPage(driver);
        dynamicElementsPage.waitForFirstButtonEnabled();
        dynamicElementsPage.clickFirstButton();
    }


    @Test
    @DisplayName("Button color changes after 5 seconds")
    public void colorChangeButtonTest(){
        DynamicElementsPage dynamicElementsPage = new DynamicElementsPage(driver);
        dynamicElementsPage.waitForColourChange();
    }


    @Test
    @DisplayName("Button is visible after 5 seconds")
    public void invisibleButtonTest(){
        DynamicElementsPage dynamicElementsPage = new DynamicElementsPage(driver);
        dynamicElementsPage.waitForVisibility();
    }

}
