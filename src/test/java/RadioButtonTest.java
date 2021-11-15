import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RadioButtonPage;
import static org.junit.jupiter.api.Assertions.*;

public class RadioButtonTest extends BaseTest{

    @Test
    @DisplayName("Click Impressive button")
    @Disabled("Need fix")
    public void clickTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickRadioButton("impressive");
        assertTrue(radioButtonPage.isRadioButtonSelected("impressive"));
    }

    @Test
    @DisplayName("No Radio button is disabled")
    @Disabled("Need fix")
    public void noRadioButtonDisabledTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        assertTrue(radioButtonPage.isRadioButtonEnabled("no"));
    }

}
