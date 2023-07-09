package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends ElementAction {
   private final WebDriver driver;
    protected By bookSection=By.cssSelector( "a[href=\"/books\"]");
    protected By giftSection=By.cssSelector( "a[href=\"/gift-cards\"]");
    protected By prideBook=By.cssSelector( "a[href=\"/pride-and-prejudice\"]");
   protected By addWinToCart=By.cssSelector("button[id=\"add-to-cart-button-11\"]");
   protected By addToCart=By.cssSelector("button[id=\"add-to-cart-button-39\"]");
   protected By compSection=By.cssSelector("a[href=\"/computers\"]");
    protected By softwareSection=By.linkText("Software");
    protected By cartPage=By.cssSelector("a[href=\"/cart\"]");
    protected By cartCounter=By.cssSelector("span[class=\"cart-qty\"]");
    protected By getWinPage=By.cssSelector("a[href=\"/windows-8-pro\"]");

    protected By recipient_name =By.className("recipient-name");
    protected By recipient_email =By.id("giftcard_43_RecipientEmail");
    protected By sender_name =By.className("sender-name");
    protected By sender_mail =By.className("sender-email");
    protected By addGiftToWishList=By.cssSelector("button[id=\"add-to-wishlist-button-43\"]");
    protected By go_home=By.cssSelector("a[href=\"/\"]");
    protected By close=By.cssSelector("span[class=\"close\"]");
    protected By num_of_items=By.cssSelector("input[id=\"product_enteredQuantity_11\"]");
    protected By wishlistCount=By.cssSelector("span[class=\"wishlist-qty\"]");
    protected By getGiftPage=By.linkText("$25 Virtual Gift Card");

    public ShoppingCartPage(WebDriver driver) {
        this.driver=driver;
    }


    public void setAddWinToCart() {
        driver.findElement(addWinToCart).click();
    }
    public void getAddToCart() {
        driver.findElement(addToCart).click();
    }
    public void send_recipient_name(String name) {
        driver.findElement(recipient_name).sendKeys(name);
    }
    public void send_recipient_email(String email) {
        driver.findElement(recipient_email).sendKeys(email);
    }public void get_sender_name(String name) {
        driver.findElement(sender_name).sendKeys(name);
    }public void get_sender_mail(String name) {
        driver.findElement(sender_mail).sendKeys(name);
    }
    public void click_addToWishList() {
        scroll_down(driver);
        driver.findElement(addGiftToWishList).click();
    }
    public void click_go_home() {
        driver.findElement(go_home).click();
    }
    public void click_close() {
        driver.findElement(close).click();
    }

    public void gotoBookSection() {
        driver.findElement(bookSection).click();
    }
    public void gotoPrideBookPage() {
        driver.findElement(prideBook).click();
    }
    public void gotoComputerPage() {
        driver.findElement(compSection).click();
    }
    public void goGiftPage() {
        driver.findElement(getGiftPage).click();
    }
    public void gotoWin8Page() {
        driver.findElement(getWinPage).click();
    }
    public void setNum_of_items(String num) {
       WebElement itemNum= driver.findElement(num_of_items);
       itemNum.sendKeys(num);
    }
    public void gotoSoftPage() {
        wait_element(driver,10,softwareSection);
      WebElement soft=  driver.findElement(softwareSection);
      soft.click();
    }
    public String getCartCounter() {
        wait_element(driver,10,cartCounter);
        return driver.findElement(cartCounter).getText();
    }
    public String getWishlistCounter() {
        wait_element(driver,10,wishlistCount);
        return driver.findElement(wishlistCount).getText();
    }
    public void gotoCartPage() {
        wait_element(driver,10,cartPage);
        WebElement cart=  driver.findElement(cartPage);
        cart.click();
    }




}
