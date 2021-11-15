package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends BasePage{

    private final By expandAllButtonLocator = new By.ByCssSelector("button.rct-option-expand-all");
    private final By collapseAllButtonLocator = new By.ByCssSelector("button.rct-option-collapse-all");
    private final By parentNodeLocator = new By.ByCssSelector("li.rct-node");
    private final By checkBoxLocator = new By.ByCssSelector("span.rct-checkbox svg");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + "/checkbox");
    }

    public void expandAll(){
        click(expandAllButtonLocator);
    }

    public void collapseAll(){
        click(collapseAllButtonLocator);
    }

    public boolean isExpanded(){
        String className = getAttribute(parentNodeLocator, "class");
        return className.contains("expanded");
    }

    public boolean isCollapsed(){
        String className = getAttribute(parentNodeLocator, "class");
        return className.contains("collapsed");
    }

    public void clickCheckBox(int i){
        click(findAll(checkBoxLocator).get(i));
    }

    public boolean isCheckboxSelected(int i){
       return findAll(checkBoxLocator).get(i).getAttribute("class").contains("check");
    }


}
