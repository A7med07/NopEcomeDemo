package tests;

import Base.Base_Page;
import DDT.ReadSheet;
import Pages.LoginPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginTest extends Base_Page {
    @Test(dataProvider = "TestData" ,priority = 1)
    public void signingTest
            (String FirstName,String LastName,String Email,String Company,String Password,String ConfirmPassword,String Gender) throws InterruptedException {
        var loginPage= h.sign_in();
        loginPage.setEmail(Email);
        loginPage.setPassword(Password);
        loginPage.click_Log_in();
        loginPage.clickMyAccount();
        //making soft assertion to check user data
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getFirstName(),FirstName);
        softAssert.assertEquals(loginPage.getLastName(),LastName);
        softAssert.assertEquals(loginPage.getEmail(),Email);
        softAssert.assertEquals(loginPage.getCompany(),Company);
        softAssert.assertAll();

        loginPage.click_Log_Out();

    }
    //creating method to check response for unregistered user
    @Test(priority = 2)
    public void InvalidLogin() throws InterruptedException {

        LoginPage lg= h.sign_in();
        lg.setEmail("notregister@nopecommerce.com");
        lg.setPassword("Password");
        lg.click_Log_in();
        lg.getInvaldMessage();
        Assert.assertEquals(lg.getInvaldMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }
    @DataProvider(name = "TestData")
    public String[][] testSheet() throws InvalidFormatException, IOException {
        ReadSheet td = new ReadSheet();
        return td.read_data();

    }

}
