import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CheckBoxPage;
import static org.junit.jupiter.api.Assertions.*;

public class CheckBoxTest extends BaseTest{

    @Test
    @DisplayName("Expand the list")
    public void expandAllTest(){
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        assertTrue(checkBoxPage.isCollapsed());
        checkBoxPage.expandAll();
        assertTrue(checkBoxPage.isExpanded());
    }

    @Test
    @DisplayName("Collapse the list")
    public void collapseAllTest(){
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        checkBoxPage.collapseAll();
        assertTrue(checkBoxPage.isCollapsed());
    }

    @Test
    @DisplayName("Click parent checkbox")
    public void clickParenCheckBoxTest(){
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.clickCheckBox(0);
        assertTrue(checkBoxPage.isCheckboxSelected(0));
    }

}
