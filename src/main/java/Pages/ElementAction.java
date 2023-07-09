package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementAction {

	private WebDriver driver ;

	public void scroll_down(WebDriver driver) {
		JavascriptExecutor java = (JavascriptExecutor)driver;
		WebElement bElement ;
		java.executeScript("scroll(0,250)");


	}
	public void wait_element(WebDriver driver,int time,By element) {
		 WebDriverWait wait=new  WebDriverWait(driver, Duration.ofSeconds(time));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	
	  
	}