package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage{

    private final By userNameLocator = By.id("userName");
    private final By userEmailLocator = By.id("userEmail");
    private final By currentAddressLocator = By.id("currentAddress");
    private final By permanentAddressLocator = By.id("permanentAddress");
    private final By submitButtonLocator = By.id("submit");
    private final By addLocator = new By.ByCssSelector("iframe[title='3rd party ad content']");
    private final By closeAddButtonLocator = new By.ByCssSelector("label[id='cbb']");

    public TextBoxPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + "/text-box");
    }

    public void setUsername(String username){
        type(userNameLocator, username);
    }

    public void setEmail(String email){
        type(userEmailLocator, email);
    }

    public void setCurrentAddress(String address){
        type(currentAddressLocator, address);
    }

    public void setPermanentAddress(String address){
        type(permanentAddressLocator, address);
    }

    public void clickSubmitButton(){
        closeAdd();
        click(submitButtonLocator);
    }

    public String getUsername(){
        return getText(userNameLocator);
    }

    public String getEmail(){
        return getText(userEmailLocator);
    }

    public String getCurrentAddress(){
        return getText(currentAddressLocator);
    }

    public String getPermanentAddress(){
        return getText(permanentAddressLocator);
    }

    public boolean checkIncorrectEmailError(){
        return getAttribute(userEmailLocator,"class").equals("mr-sm-2 field-error form-control");
    }

    private void closeAdd(){
        driver.switchTo().frame(find(addLocator));
        click(closeAddButtonLocator);
        driver.switchTo().defaultContent();
    }

    @Override
    protected String getText(By locator) {
        return find(locator).getAttribute("value");
    }

}
