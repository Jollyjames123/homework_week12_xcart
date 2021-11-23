package homepage;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities_self.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li"));
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(500);
                name.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        //1.1 using selectmenu method from above
        selectMenu("Shipping");
        //1.2
        doAssertToVerifyElements("Shipping is not displayed correctly", "Shipping", By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException{
        //1.3
        selectMenu("New!");
        //1.4
        doAssertToVerifyElements("New Arrivals is not displayed correctly", "New arrivals", By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully() throws InterruptedException{
        //1.5
        selectMenu("Coming soon");
        //1.6
        doAssertToVerifyElements("Coming soon is not displayed correctly", "Coming soon", By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException{
        //1.7
        selectMenu("Contact us");
        //1.8
        doAssertToVerifyElements("Contact us is not displayed correctly", "Contact us", By.xpath("//h1[@id='page-title']"));
    }

    @After
    public void tearDown(){
       closeBrowser();
    }
}
