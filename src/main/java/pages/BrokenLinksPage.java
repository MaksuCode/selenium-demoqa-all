package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrokenLinksPage extends BasePage{

    private final By validLinkLocator = By.xpath("//div[@class='col-12 mt-4 col-md-6']/div/a[1]");
    private final By invalidLinkLocator = By.xpath("//div[@class='col-12 mt-4 col-md-6']/div/a[2]");
    private final By brokenImageLinkLocator = By.xpath("//div[@class='col-12 mt-4 col-md-6']/div/img[2]");

    public BrokenLinksPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + "/broken");
    }

    public String getValidLink(){
        return getAttribute(validLinkLocator, "href");
    }

    public String getInvalidLink(){
        return getAttribute(invalidLinkLocator, "href");
    }

    public String getImageLink() {
        return getAttribute(brokenImageLinkLocator, "src");
    }
}
