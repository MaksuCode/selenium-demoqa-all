package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicElementsPage extends BasePage{

    private final By enableAfterButtonLocator = By.id("enableAfter");
    private final By colorChangerButtonLocator = By.id("colorChange");
    private final By visibleAfterButtonLocator = By.id("visibleAfter");

    public DynamicElementsPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + "/dynamic-properties");
    }

    public void waitForFirstButtonEnabled(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(find(enableAfterButtonLocator)));
    }

    public void clickFirstButton(){
        click(enableAfterButtonLocator);
    }

    public void waitForColourChange(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeToBe(colorChangerButtonLocator, "class", "mt-4 text-danger btn btn-primary"));
    }

    public void waitForVisibility(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleAfterButtonLocator));
    }



}
