package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonsPage extends BasePage{

    private By doubleClickBtnLocator = By.id("doubleClickBtn");
    private By rightClickBtnLocator = By.id("rightClickBtn");
    private By clickBtnLocator = By.xpath("//div/button[starts-with(text(), 'Click')]");

    private By doubleClickMessageLocator = By.id("doubleClickMessage");
    private By rightClickMessageLocator = By.id("rightClickMessage");
    private By dynamicClickMessageLocator = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + "/buttons");
    }

    public void doubleClickButton(){
        doubleClick(doubleClickBtnLocator);
    }

    public void rightClickButton(){
        rightClick(rightClickBtnLocator);
    }

    public void clickButton(){
        click(clickBtnLocator);
    }

    public String getMessage(String clickType){
        String text = "default";
        switch (clickType){
            case "double":
                text = getText(doubleClickMessageLocator);
                break;
            case "right":
                text = getText(rightClickMessageLocator);
                break;
            case "dynamic":
                text = getText(dynamicClickMessageLocator);
                break;
        }
        return text ;
    }

}
