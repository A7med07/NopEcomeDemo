package Base;

import Pages.LoginPage;
import Pages.Registeration;
import Pages.Search;
import Pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected By addFirsttItem=By.cssSelector("a[href=\"/25-virtual-gift-card\"]");

    private final WebDriver driver;
    private final By log_in= By.linkText("Log in");
    private final By Register= By.linkText("Register");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    public LoginPage sign_in(){

        driver.findElement(log_in).click();
        return new LoginPage(driver);
    }
    public Registeration clickRegister(){
        driver.findElement(Register).click();
        return new Registeration(driver);
    }
    public ShoppingCartPage shopping(){

        return  new ShoppingCartPage(driver);
    }
    public Search searchForProduct(){
        return  new Search(driver);
    }
}
