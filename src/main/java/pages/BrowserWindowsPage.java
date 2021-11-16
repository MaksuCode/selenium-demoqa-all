package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");
    private final By messageWindowButton = By.id("messageWindowButton");

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + "/browser-windows");
    }

    public void clickNewTabButton(){
        click(newTabButton);
    }

    public List<String> getTabs(){
        return new ArrayList<>(driver.getWindowHandles());
    }

    public String getNewTabUrl(){
        return driver.switchTo().window(getTabs().get(1)).getCurrentUrl();
    }

    public void clickNewWindowButton(){click(newWindowButton);}

    public void clickMessageWindowButton(){click(messageWindowButton);}


    // TODO: 17.11.2021 fix : It can not go to newly opened window, taking too much time. 
    public String getMessageOnNewWindow(){
        return driver.switchTo().window(getTabs().get(1)).getTitle();
    }


}
