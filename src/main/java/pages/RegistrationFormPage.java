package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationFormPage extends BasePage {

    private final By firstNameLocator = By.id("firstName");
    private final By lastNameLocator = By.id("lastName");
    private final By emailLocator = By.id("userEmail");
    private final By ageLocator = By.id("age");
    private final By salaryLocator = By.id("salary");
    private final By departmentLocator = By.id("department");
    private final By submitButtonLocator = By.id("submit");


    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public void createNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        type(firstNameLocator, firstName);
        type(lastNameLocator, lastName);
        type(emailLocator, email);
        type(ageLocator, age);
        type(salaryLocator, salary);
        type(departmentLocator, department);
        click(submitButtonLocator);
    }

    public void editRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        edit(firstNameLocator, firstName);
        edit(lastNameLocator, lastName);
        edit(emailLocator, email);
        edit(ageLocator, age);
        edit(salaryLocator, salary);
        edit(departmentLocator, department);
        click(submitButtonLocator);
    }

}
