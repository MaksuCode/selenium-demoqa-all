import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxTest extends BaseTest{

    @Test
    @DisplayName("Set full name")
    public void setFullNameTest(){
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.setUsername("Mustafa Aksu");
        assertEquals("Mustafa Aksu", textBoxPage.getUsername());
    }

    @Test
    @DisplayName("Set email with correct format")
    public void setEmailTest(){
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.setEmail("mustafaksu123@gmail.com");
        assertEquals("mustafaksu123@gmail.com", textBoxPage.getEmail());
    }

    @Test
    @DisplayName("Set email with incorrect format")
    public void setEmailWithIncorrectFormatTest(){
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.setEmail("mustafa.gmail.com");
        textBoxPage.clickSubmitButton();
        assertTrue(textBoxPage.checkIncorrectEmailError());
    }

    @Test
    @DisplayName("Set address")
    public void setCurrentAddressTest(){
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.setCurrentAddress("Ankara, Turkey");
        assertEquals("Ankara, Turkey", textBoxPage.getCurrentAddress());
    }

}
