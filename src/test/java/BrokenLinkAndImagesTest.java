import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BrokenLinksPage;

import static io.restassured.RestAssured.get;

public class BrokenLinkAndImagesTest extends BaseTest{

    @Test
    @DisplayName("Valid link returns 200")
    public void validLinkTest(){
        BrokenLinksPage linksPage = new BrokenLinksPage(driver);
        String link = linksPage.getValidLink();
        get(link).then().statusCode(200);
    }

    @Test
    @DisplayName("Broken link returns 500")
    public void inValidLinkTest(){
        BrokenLinksPage linksPage = new BrokenLinksPage(driver);
        String link = linksPage.getInvalidLink();
        get(link).then().statusCode(500);
    }

    @Test
    @DisplayName("Broken image test")
    public void brokenImageTest(){
        BrokenLinksPage linksPage = new BrokenLinksPage(driver);
        String link = linksPage.getImageLink();
        get(link).then().statusCode(500);  // The image appears to ne not a broken img so that this test will fail.
    }

}
