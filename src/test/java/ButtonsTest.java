import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ButtonsPage;

public class ButtonsTest extends BaseTest{

    @Test
    @DisplayName("Double click")
    public void doubleClickTest(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.doubleClickButton();
        Assertions.assertEquals("You have done a double click", buttonsPage.getMessage("double"));
    }

    @Test
    @DisplayName("Right click")
    public void rightClickTest(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.rightClickButton();
        Assertions.assertEquals("You have done a right click", buttonsPage.getMessage("right"));
    }

    @Test
    @DisplayName("Dynamic click")
    public void dynamicClickTest(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickButton();
        Assertions.assertEquals("You have done a dynamic click", buttonsPage.getMessage("dynamic"));
    }

}
