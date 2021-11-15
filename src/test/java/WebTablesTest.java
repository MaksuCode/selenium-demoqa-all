import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebTablesPage;


public class WebTablesTest extends BaseTest {

    @Test
    @DisplayName("Add a new record to table")
    public void addNewRecordTest(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.clickAddNewRecordButton();
        webTablesPage
                .registrationFormPage()
                .createNewRecord("Mustafa" , "Aksu", "mustafa123@gmail.com" ,
                        "26", "2500","Tech");
        Assertions.assertTrue(webTablesPage.webTable().checkRow("Mustafa","Aksu",
                "mustafa123@gmail.com",
                "26","2500", "Tech"));
    }

    @Test
    @DisplayName("Search a valid value")
    public void searchTestPositive(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.search("Cierra");
        Assertions.assertEquals("Cierra", webTablesPage.webTable().getRowValues(1).get(0), "Search failed!");
    }

    @Test
    @DisplayName(("Search a invalid value"))
    public void searchTestNegative(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.search("Mustafa");
        Assertions.assertTrue(webTablesPage.webTable().noDataTextPresent(), "No data message is not present!");
    }

    @Test
    @DisplayName("Delete a record")
    public void deleteRecordTest(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.webTable().deleteRecord("1");
        Assertions.assertEquals(8,  webTablesPage.webTable().getEmptyRowCount());
    }

    @Test
    @DisplayName("Edit a row")
    public void editRowTest(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.webTable().editRow("1" , "Mustafa");
        Assertions.assertEquals("Mustafa", webTablesPage.webTable().getRowValues(1).get(0), "Edit failed!");
    }

}
