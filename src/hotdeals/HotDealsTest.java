package hotdeals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities_self.Utility;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //1.1, 1.2
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"), By.xpath("(//span[contains(text(),'Sale')])[2]"));
        //1.3 Verify the text "Sale"
        doAssertToVerifyElements("Message is not displayed correctly", "Sale", By.xpath("//h1[@id='page-title']"));
        //1.4
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//span[contains(text(),'Sort by:')]"), By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(1000);
        //1.5 Verify that the product arrange alphabetically
        String expectedMessage = "Name A - Z";
        String actualMessage = driver.findElement(By.xpath("//span[@class='sort-by-value']")).getText();
        Assert.assertEquals("Products are not sorted alphabetically", expectedMessage, actualMessage);

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //2.1, 2.2
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"), By.xpath("(//span[contains(text(),'Sale')])[2]"));
        //2.3 Verify the text "Sale"
        Thread.sleep(500);
        doAssertToVerifyElements("Message is not displayed correctly", "Sale", By.xpath("//h1[@id='page-title']"));
        //2.4
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//span[contains(text(),'Sort by:')]"), By.xpath("//a[contains(text(),'Price Low - High')]"));
        Thread.sleep(1000);
        //2.5
        String expectedMessage1 = "Price Low - High";
        String actualMessage1 = doGetTextFromElement(By.xpath("//span[@class='sort-by-value']"));
        Assert.assertEquals("Prices are not arranged low to high", expectedMessage1, actualMessage1);

    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        //3.1, 3.2
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"), By.xpath("(//span[contains(text(),'Sale')])[2]"));
        //3.3 Verify the text "Sale"
        doAssertToVerifyElements("Message is not displayed correctly", "Sale", By.xpath("//h1[@id='page-title']"));
        //3.4
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//span[contains(text(),'Sort by:')]"), By.xpath("//a[contains(text(),'Rates')]"));
        Thread.sleep(1000);
        //3.5
        String expectedMessage1 = "Rates";
        String actualMessage1 = doGetTextFromElement(By.xpath("//span[@class='sort-by-value']"));
        Assert.assertEquals("Products are not arranged correctly", expectedMessage1, actualMessage1);

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        //4.1, 4.2
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"), By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //4.3 Verify the text "Bestsellers"
        doAssertToVerifyElements("Message is not displayed correctly", "Bestsellers", By.xpath("//h1[@id='page-title']"));
        //4.4
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//span[contains(text(),'Sort by:')]"), By.xpath("//a[contains(text(),'Name Z - A')]"));
        Thread.sleep(1000);
        //4.5
        String expectedMessage = "Name Z - A";
        String actualMessage = doGetTextFromElement(By.xpath("//span[@class='sort-by-value']"));
        Assert.assertEquals("Products are not arranged correctly", expectedMessage, actualMessage);
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //5.1, 5.2
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"), By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //5.3 Verify the text "Bestsellers"
        doAssertToVerifyElements("Message is not displayed correctly", "Bestsellers", By.xpath("//h1[@id='page-title']"));
        //5.4
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//span[contains(text(),'Sort by:')]"), By.xpath("//a[contains(text(),'Price High - Low')]"));
        Thread.sleep(1500);
        //5.5
        String expectedMessage1 = "Price High - Low";
        String actualMessage1 = doGetTextFromElement(By.xpath("//span[@class='sort-by-value']"));
        Assert.assertEquals("Products are not arranged correctly", expectedMessage1, actualMessage1);

    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //6.1, 6.2
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"), By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //6.3 Verify the text "Bestsellers"
        doAssertToVerifyElements("Message is not displayed correctly", "Bestsellers", By.xpath("//h1[@id='page-title']"));
        //6.4
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//span[contains(text(),'Sort by:')]"), By.xpath("//a[contains(text(),'Rates')]"));
        Thread.sleep(1500);
        //5.5
        String expectedMessage1 = "Rates";
        String actualMessage1 = doGetTextFromElement(By.xpath("//span[@class='sort-by-value']"));
        Assert.assertEquals("Products are not arranged correctly", expectedMessage1, actualMessage1);

    }

    public void tearDown() {
        closeBrowser();
    }
}
