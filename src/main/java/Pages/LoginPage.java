package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ElementAction {
    private final WebDriver driver;
    protected By email=By.id("Email");
    protected By password=By.id("Password");
    protected  By log_in_bt=By.cssSelector("button[class=\"button-1 login-button\"]");
    protected  By log_Out_bt=By.cssSelector("a[href=\"/logout\"]");
    protected  By myAccount=By.cssSelector("a[href=\"/customer/info\"]");
    protected By firstName =By.cssSelector("input[id=\"FirstName\"]");
    protected By lastName =By.cssSelector("input[id=\"LastName\"]");
    protected By get_email =By.cssSelector("input[id=\"Email\"]");
    protected By get_company =By.cssSelector("input[id=\"Company\"]");

    protected By invald_Message =By.cssSelector("div[class=\"message-error validation-summary-errors\"]");
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }
public void setEmail(String e_mail){
        driver.findElement(email).sendKeys(e_mail);
}
    public void setPassword(String pswd){
        driver.findElement(password).sendKeys(pswd);
    }
    public void click_Log_in() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(log_in_bt).click();
    }
    public void click_Log_Out() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(log_Out_bt).click();
    }
    public void clickMyAccount() throws InterruptedException {
        wait_element(driver,20,myAccount);
        Thread.sleep(1000);
        driver.findElement(myAccount).click();
    }
    public String getFirstName(){
        wait_element(driver,20,firstName);
        driver.findElement(firstName).click();
        String text = driver.findElement(firstName).getAttribute("value");
        return text;
    } public String getLastName(){
        wait_element(driver,20,lastName);
        driver.findElement(lastName).click();
        String text = driver.findElement(lastName).getAttribute("value");
        return text;
    } public String getEmail(){
        scroll_down(driver);
        driver.findElement(get_email).click();
        String text = driver.findElement(get_email).getAttribute("value");
        wait_element(driver,20,get_email);
        return text;
    }
    public String getCompany(){
        driver.findElement(get_company).click();
        scroll_down(driver);
        String text = driver.findElement(get_company).getAttribute("value");
        wait_element(driver,20,get_email);
        return text;
    }
    public String getInvaldMessage(){
        String text = driver.findElement(invald_Message).getText();
        return text;
    }

}
