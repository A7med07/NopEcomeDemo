package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Registeration extends ElementAction {

    private final WebDriver driver;
    protected  By text= By.className("result");
    protected By continueBt=By.cssSelector("div>a[class=\"button-1 register-continue-button\"]");
    protected By male= By.id("gender-male");
    protected By female= By.cssSelector("input[id=\"gender-female\"]");
    protected By FirstName= By.id("FirstName");
    protected By LastName= By.id("LastName");
    protected By Email= By.id("Email");
    protected By Company= By.id("Company");
    protected By Password= By.id("Password");
    protected By ConfirmPassword= By.id("ConfirmPassword");
    protected By register_button= By.id("register-button");
    protected By birthDaySelection=By.name("DateOfBirthDay");
    protected By DateOfBirthMonth=By.name("DateOfBirthMonth");
    protected By DateOfBirthYear=By.name("DateOfBirthYear");

    public Registeration(WebDriver driver) {
        this.driver=driver;
    }

    public void setEmail(String e_mail){
        driver.findElement(Email).sendKeys(e_mail);
    }
    public void setFirstName(String First_Name){
        driver.findElement(FirstName).sendKeys(First_Name);
    }
    public void setLastName(String Last_Name){
        driver.findElement(LastName).sendKeys(Last_Name);
    }
    public void setPassword(String pswd){
        wait_element(driver,10,Password);
        scroll_down(driver);
        WebElement password=driver.findElement(Password);
        password.sendKeys(pswd);
    }
    public void setConfirmPassword(String pswd){
        wait_element(driver,10,ConfirmPassword);
        scroll_down(driver);
        WebElement password= driver.findElement(ConfirmPassword);
        password.sendKeys(pswd);
    }
    public void setCompany(String comp){
        scroll_down(driver);
        driver.findElement(Company).sendKeys(comp);
    }
    public void selectMale(){
       WebElement Male= driver.findElement(male);
       Male.click();
    }
    public void selectFemale(){
        WebElement Female=driver.findElement(female);
        Female.click();
    }

    public void register_submit(){
        scroll_down(driver);
        wait_element(driver,10,register_button);
       WebElement register= driver.findElement(register_button);
       register.click();
    }

    public void selectFromDay(int option){
        findDropDownDay().selectByIndex(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownDay().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownDay(){
        return new Select(driver.findElement(birthDaySelection));
    }
    public void selectFromMonth(int option){
        findDropDownMonth().selectByIndex(option);
    }

    public List<String> getSelectedMonth(){
        List<WebElement> selectedElements = findDropDownMonth().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownMonth(){
        return new Select(driver.findElement(DateOfBirthMonth));
    }
    public void selectFromYear(int option){
        findDropDownYear().selectByIndex(option);
    }

    public List<String> getSelectedYear(){
        List<WebElement> selectedElements = findDropDownYear().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownYear(){
        return new Select(driver.findElement(DateOfBirthYear));
    }
    public void clickContinueBt() throws InterruptedException {
        wait_element(driver,15,continueBt);
        Thread.sleep(1500);
        driver.findElement(continueBt).click();
    }
    public String getText(){
       String t= driver.findElement(text).getText();
       return t;
    }

}

