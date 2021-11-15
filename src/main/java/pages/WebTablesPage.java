package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage extends BasePage{

    private RegistrationFormPage registrationFormPage;
    private WebTable webTable;
    private final By addNewRecordButtonLocator = By.id("addNewRecordButton");
    private By searchBoxLocator = By.id("searchBox");

    public WebTablesPage(WebDriver driver) {
        super(driver);
        this.registrationFormPage = new RegistrationFormPage(driver);
        this.webTable = new WebTable(driver);
        driver.get(baseUrl + "/webtables");
    }

    public RegistrationFormPage registrationFormPage() {
        return registrationFormPage;
    }

    public WebTable webTable() {
        return webTable;
    }

    public void clickAddNewRecordButton(){
        click(addNewRecordButtonLocator);
    }

    public void search(String text){
        type(searchBoxLocator, text);
    }

}


