package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://demoqa.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        find(locator).click();
    }

    protected void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void doubleClick(By locator){
        Actions action = new Actions(driver);
        action.doubleClick(find(locator)).perform();
    }

    protected void rightClick(By locator){
        Actions action = new Actions(driver);
        action.contextClick(find(locator)).perform();
    }

    protected void type(By locator, String text){
        if (!(text == null)){
            find(locator).sendKeys(text);
        }
    }

    protected void edit(By locator, String text){
        if (!(text == null)){
            WebElement element = find(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    protected WebElement find(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    protected boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    protected boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    protected boolean isSelected(WebElement element){
        return element.isSelected();
    }

    protected boolean isEnabled(WebElement element){
        return element.isEnabled();
    }

    protected boolean isEnabled(By locator){
        return find(locator).isEnabled();
    }

    protected String getAttribute(By locator, String attributeName){
        return find(locator).getAttribute(attributeName);
    }

    protected String getText(By locator){
        return find(locator).getText();
    }

}
