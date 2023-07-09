package tests;

import Base.Base_Page;
import DDT.ReadSheet;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestShoppingCart extends Base_Page {

    @Test(dataProvider = "Test_Shopping")

    public void shopping (String FirstName,String LastName,String Email,String Company,String Password,String ConfirmPassword,String Gender) throws InterruptedException {
        var loginPage= h.sign_in();
        loginPage.setEmail(Email);
        loginPage.setPassword(Password);
        loginPage.click_Log_in();
        var sh= h.shopping();
        sh.click_go_home();
        //adding book
        sh.gotoBookSection();
        sh.gotoPrideBookPage();
        sh.getAddToCart();
        sh.click_go_home();
        //adding Windows 8
        sh.gotoComputerPage();
        sh.gotoSoftPage();
        sh.gotoWin8Page();
        sh.setNum_of_items("3");
        sh.setAddWinToCart();
        Assert.assertNotEquals(sh.getCartCounter(),"(0)");
        //send gift
        sh.click_go_home();
        sh.goGiftPage();
        sh.send_recipient_name("Gift for"+LastName);
        sh.send_recipient_email("gift"+Email);
        sh.click_addToWishList();
        Assert.assertNotEquals(sh.getWishlistCounter(),"(0)");
        //logout
        loginPage.click_Log_Out();



    }
    @DataProvider(name = "Test_Shopping")
    public String[][] Test_Data() throws InvalidFormatException, IOException {
        ReadSheet td = new ReadSheet();
        return td.read_data();

    }


}
