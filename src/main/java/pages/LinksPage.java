package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksPage extends BasePage{

    private final By createdLocator = By.id("created");
    private final By noContentLocator = By.id("no-content");
    private final By homeLinkLocator = By.id("simpleLink");

    public LinksPage(WebDriver driver) {
        super(driver);
//        driver.get(baseUrl + "links");
    }

    public void clickCreated(){
        click(createdLocator);
    }

    public void clickNoContent(){
        click(noContentLocator);
    }

    public void clickHome(){
        click(homeLinkLocator);
    }

}
