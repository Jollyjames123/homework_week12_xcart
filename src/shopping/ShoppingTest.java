package shopping;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities_self.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {

        doMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        doMouseHoverAndClickAction(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        doAssertToVerifyElements("Sale page not displayed correctly", "Sale", By.xpath("//h1[@id='page-title']"));
        //1.4
        doMouseHoverAction(By.xpath("//span[contains(text(),'Sort by:')]"));
        doClickOnElement(By.partialLinkText("Name A -"));
        //1.5
        doMouseHoverAction(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(2000);
        doClickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));


        // 1.6
        doAssertToVerifyElements("Product has been added to your cart is not displayed", "Product has been added to your cart", By.xpath("//li[@class='info']"));

        //1.7 Click on X sign to close the message
        doClickOnElement(By.cssSelector("a[title='Close']"));

        //1.8Click on “Your cart” icon and Click on “View cart” button
        doClickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(500);
        doClickOnElement(By.xpath("//span[normalize-space()='View cart']"));

        //1.9 Verify the text
        doAssertToVerifyElements("Shopping cart is not displayed correctly", "Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"));

        //1.10 Change the Qty = 2
        driver.findElement(By.xpath("//input[@id='amount16']")).clear();
        Thread.sleep(1000);
        doSendTextToElement(By.xpath("//input[@id='amount16' and @name='amount']"), "2");
        Thread.sleep(3500);
        // String expectedMessage = "2";
        //String actualMessage = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/input[1]")).getAttribute("value");
        //Assert.assertEquals("Quantity is not correct", expectedMessage, actualMessage);
        //Thread.sleep(500);

        doAssertToVerifyElements("Shopping cart is not displayed correctly", "Your shopping cart - 2 items", By.xpath("//h1[@id='page-title']"));
        Thread.sleep(1000);
        doAssertToVerifyElements("Subtotal is not displayed correctly", "$29.98", By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']"));
        Thread.sleep(500);
        doAssertToVerifyElements("Total is incorrect", "$36.00", By.xpath("//li[@class='total']//span[@class='surcharge']"));

        //1.14 Click on “Go to checkout” button
        doClickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));

        //1.15Verify the text “Log in to your account”
        doAssertToVerifyElements("Message is not displayed correctly", "Log in to your account", By.xpath("//h3[contains(text(),'Log in to your account')]"));

        //1.16 Enter Email address
        doSendTextToElement(By.cssSelector("#email"), emailString() + "@gmail.com");//random email selection

        //1.17
        doClickOnElement(By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]"));

        //1.18
        doAssertToVerifyElements("Message is displayed incorrectly", "Secure Checkout", By.cssSelector(".title"));

        //1.19 Fill all the mandatory fields
        doSendTextToElement(By.id("shippingaddress-firstname"), "Jolly");
        doSendTextToElement(By.id("shippingaddress-lastname"), "James");
        doSendTextToElement(By.id("shippingaddress-street"), "999 Prime Road");
        doSendTextToElement(By.id("shippingaddress-custom-state"), "London");
        doClickOnElement(By.id("create_profile"));
        doSendTextToElement(By.id("password"), "1234567");

        //1.22Select the Delivery Method to “Local Shipping”
        doClickOnElement(By.id("method128"));
        Thread.sleep(1500);

        //1.23
        doClickOnElement(By.id("pmethod6"));
        Thread.sleep(1500);

        //1.24
        doAssertToVerifyElements("Total is displayed incorrectly", "$37.03", By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"));
        Thread.sleep(1500);

        //1.25
        doClickOnElement(By.xpath("//span[contains(text(),'Place order: $37.03')]"));
        Thread.sleep(3000);

        //1.26  “Thank you for your order”
        doAssertToVerifyElements("Message displayed incorrectly", "Thank you for your order", By.xpath("//h1[@id='page-title']"));

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //2.1
        doMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        // 2.2
        doMouseHoverAndClickAction(By.xpath("//li[@class='leaf has-sub']//ul[1]//li[2]/a[1]/span"));

        //2.3 Verify the text
        Thread.sleep(500);
        doAssertToVerifyElements("Bestsellers is not displayed correctly", "Bestsellers", By.xpath("//h1[@id='page-title']"));

        //2.4 Mouse hover on “Sort By” and select “Name A-Z”
        doMouseHoverAction(By.xpath("//span[contains(text(),'Sort by:')]"));
        doClickOnElement(By.linkText("Name A - Z"));

        //2.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        doMouseHoverAction(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']//span"));
        Thread.sleep(500);
        doClickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']//span"));
        Thread.sleep(500);
        //2.6 Verify the message “Product has been added to your cart” display in  green bar
        //doAssertToVerifyElements("Product added - displayed incorrectly", "Product has been added to your cart", By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        doAssertToVerifyElements("Product added - displayed incorrectly", "Product has been added to your cart", By.xpath("//div[@id='status-messages']"));

        //2.7 Click on X sign to close the message
        Thread.sleep(500);
        doClickOnElement(By.xpath("//a[@class='close' and @title='Close']"));

        //2.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(500);
        doClickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(500);
        doClickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //2.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(500);
        doAssertToVerifyElements("Product is not added correctly", "Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"));

        //2.10 Click on “Empty your cart” link
        Thread.sleep(500);
        doClickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //2.11 Verify the text “Are you sure you want to clear your cart?” on alert
        String actualAlert = doGetTextFromAlert();
        String expectedAlert = "Are you sure you want to clear your cart?";
        Assert.assertEquals("Alert Message is displaed incorrectly", expectedAlert, actualAlert);
        Thread.sleep(500);

        //2.12 Ok to alert
        doSwitchToAndAcceptAlert();
        Thread.sleep(1000);

        //2.13
        //doAssertToVerifyElements("item is not deleted", "Item(s) deleted from your cart", By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        doAssertToVerifyElements("item is not deleted", "Item(s) deleted from your cart", By.xpath("//div[@id='status-messages']"));
        Thread.sleep(500);

        //2.14
        doAssertToVerifyElements("your cart is not empty", "Your cart is empty", By.xpath("//h1[@id='page-title']"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

