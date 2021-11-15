package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class WebTable extends BasePage{

    private String rowXpath ="//div[@class='rt-tr-group'][";
    private String deleteRowId = "delete-record-";
    private String editRowId = "edit-record-";
    private By noDataTextLocator = new By.ByCssSelector("div.rt-noData");
    private By emptyOddRowLocator = new By.ByCssSelector("div.rt-tr[class='rt-tr -padRow -odd']");
    private By emptyEvenRowLocator = new By.ByCssSelector("div.rt-tr[class='rt-tr -padRow -even']");


    public WebTable(WebDriver driver) {
        super(driver);
    }

    public List<String> getRowValues(int row){
        List<String> values = new ArrayList<>();
        String newColumnByByRowLocator;
        for (int i = 1 ; i < 7 ; i ++){
            newColumnByByRowLocator = rowXpath + row + "]/div/div[" + i + "]";
            values.add(driver.findElement(By.xpath(newColumnByByRowLocator)).getText());
        }
        return values;
    }

    // TODO: 9.11.2021 Find a better solution! 
    public boolean checkRow(String name, String lastName, String email , String age , String salary, String department){
        List<String> values = getRowValues(4);
        return values.get(0).equals(name) && values.get(1).equals(lastName) && values.get(2).equals(age)
                && values.get(3).equals(email) && values.get(4).equals(salary) && values.get(5).equals(department);
    }

    public boolean noDataTextPresent(){
        return isDisplayed(noDataTextLocator);
    }

    public void deleteRecord(String rowNumber){
        deleteRowId = deleteRowId + rowNumber ;
        click(driver.findElement(By.id(deleteRowId)));
    }

    public int getEmptyRowCount(){
        return findAll(emptyOddRowLocator).size() + findAll(emptyEvenRowLocator).size();
    }

    public void editRow(String rowNumber, String name){
        editRowId = editRowId + rowNumber;
        click(driver.findElement(By.id(editRowId)));
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
        registrationFormPage.editRecord(name,null,null,null,null,null);
    }

}
