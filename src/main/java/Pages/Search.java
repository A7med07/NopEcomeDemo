package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Search extends ElementAction {
    private WebDriver driver;
    public By searchButton = By.cssSelector("button[class=\"button-1 search-box-button\"]");
    public By searchField = By.cssSelector("input[class=\"search-box-text ui-autocomplete-input\"]");
    public By orderby = By.cssSelector ("select[id=\"products-orderby\"]");
    public By pageSize = By.cssSelector ("select[id=\"products-pagesize\"]");
    public By searchResult = By.cssSelector("div[class=search-results]");
    public By listMode = By.cssSelector("a[class=\"viewmode-icon list selected\"]");
    public By gridMode = By.cssSelector("a[class=\"viewmode-icon grid\"]");




    public Search(WebDriver driver) {
        this.driver = driver;
    }
    public void clickSearchButton(){
        WebElement searchBt= driver.findElement(searchButton);
        searchBt.click();
    }
    public void setSearchText(String searchText){
        WebElement searchBt= driver.findElement(searchField);
        searchBt.sendKeys(searchText);
    }
    public String getSearchBody(){
        WebElement searchBt= driver.findElement(searchResult);
        String result=searchBt.getText();
        return result;
    }
    private Select selectOrderBy(){
        return new Select(driver.findElement(orderby));
    }
    public void selectFromOrderBy(String option){
        selectOrderBy().selectByValue(option);
        scroll_down(driver);
    }


    private Select selectPageSize(){
        return new Select(driver.findElement(pageSize));
    }
    public void selectFromPageSize(String option){
        selectPageSize().selectByValue(option);
        scroll_down(driver);
    }
    public void clickListMode(){
        WebElement lMode= driver.findElement(listMode);
        lMode.click();
        scroll_down(driver);
    } public void clickGridMode(){
        WebElement gMode= driver.findElement(gridMode);
        gMode.click();
        scroll_down(driver);
    }

}