package tests;
import Base.Base_Page;
import DDT.ReadSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class RegisterTest extends Base_Page {


    @Test(dataProvider = "Test_Data")
    public void RegTest
            (String FirstName,String LastName,String Email,String Company,String Password,String ConfirmPassword,String Gender) throws InterruptedException {
        var rg= h.clickRegister();
// choosing gender according data in excel sheet
       if (Gender.equalsIgnoreCase("Male")){
        rg.selectMale();}
        else if (Gender.equalsIgnoreCase("Female")){
            rg.selectFemale();}
        rg.setFirstName(FirstName);
        rg.setLastName(LastName);
        String s ="Your registration completed";
        //choosing index number 2 in 3 lists
        int option = 2;
        rg.selectFromDay(option);
        rg.selectFromMonth(option);
        rg.selectFromYear(option);
        rg.setEmail(Email);
        rg.setCompany(Company);
        rg.setPassword(Password);
        rg.setConfirmPassword(ConfirmPassword);
        rg.register_submit();
        //check successful registration message
        assertEquals(rg.getText(),s,"Invalid message");
        rg.clickContinueBt();
    }
    @DataProvider(name = "Test_Data")
    public String[][] Test_Data() throws InvalidFormatException, IOException {
        ReadSheet td = new ReadSheet();
        return td.read_data();

    }

}
