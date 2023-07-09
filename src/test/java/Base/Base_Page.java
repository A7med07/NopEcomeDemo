package Base;

import Pages.Registeration;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Optional;

import java.io.File;
import java.io.IOException;

public class Base_Page  {
    private WebDriver driver;
    protected HomePage h;
    protected Registeration r;


    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        h=new HomePage(driver);
        r=new Registeration(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

   @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot,
                        new File("C:\\Users\\A7med\\IdeaProjects\\NopEcom\\src\\main\\resources\\ScreenShots"+
                                result.id()+ "  " +result.getName() + ".png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

   

}
