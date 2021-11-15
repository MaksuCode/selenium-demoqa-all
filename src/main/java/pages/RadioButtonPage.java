package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage{

    private final By yesRadioButtonLocator = By.id("yesRadio");
    private final By impressiveRadioButtonLocator = By.id("impressiveRadio");
    private final By noRadioButtonLocator = By.id("noRadio");
    private final By radioButtonLabelLocator = new By.ByCssSelector("label.custom-control-label");

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + "/radio-button");
    }

    public void clickRadioButton(String name){
        switch (name.toLowerCase()){
            case "yes":
                click(findAll(radioButtonLabelLocator).get(0));
                break;
            case "impressive":
                click(findAll(radioButtonLabelLocator).get(1));
                break;
        }
    }

    public boolean isRadioButtonSelected(String name){
        boolean isChecked = false;
        switch (name.toLowerCase()){
            case "yes":
                isChecked = isSelected(yesRadioButtonLocator);
                break;
            case "impressive":
                isChecked = isSelected(impressiveRadioButtonLocator);
                break;
            case "no":
                isChecked = isSelected(findAll(radioButtonLabelLocator).get(2));
                break;
        }
        return isChecked;
    }

    public boolean isRadioButtonEnabled(String name){
        boolean isEnabled = false;
        switch (name.toLowerCase()){
            case "yes":
                isEnabled = isEnabled(yesRadioButtonLocator);
                break;
            case "impressive":
                isEnabled = isEnabled(impressiveRadioButtonLocator);
                break;
            case "no":
                isEnabled = isEnabled(noRadioButtonLocator);
                break;
        }
        return isEnabled;
    }

}
