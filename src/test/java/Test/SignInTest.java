package Test;

import Pages.SignIn;
import org.junit.Assert;
import org.testng.annotations.*;
import utils.ExcelReader;

public class SignInTest extends BaseTest{

    public SignIn SN;

    @Test(dataProvider = "EmailDP")
    public void EmailStepScreen(String Email, String Case, String message, String SysMsg) throws InterruptedException {
        SN= new SignIn();
        if(Case.equalsIgnoreCase("valid"))
            Assert.assertTrue(SN.EmailPassedCases(Email));
        else
            Assert.assertTrue(SN.EmailFailedCases(Email,SysMsg));
    }

    @Test(dataProvider = "AuthenticationDP")
    public void EmailStepScreen(String Case, String	Message,
         String FirstName,
         String LastName, String Email,
         String Password,
         String AD_FirstName,
         String AD_LastName,
         String AD_COMPANY,
         String AD_ADDRESS,
         String AD_CITY,
         String PostCODE,
         String AD_ADDITIONALINFO,
         String AD_HOMEPHONE,
         String AD_MOBILEPHONE,
         String AD_ADDRESSReferenceString)throws InterruptedException {

        SN= new SignIn();
        SN.EmailPassedCases(Email);

        if(Case.equalsIgnoreCase("valid")) {
            if(!Message.equalsIgnoreCase("mandatory"))
                SN.AuthenticateUserNonMandatoryData(AD_COMPANY,AD_ADDITIONALINFO,AD_HOMEPHONE);
            Assert.assertFalse(SN.AuthonticateUserMandatoryData(FirstName, LastName, Password, AD_FirstName, AD_LastName, AD_ADDRESS, AD_CITY, AD_MOBILEPHONE, AD_ADDRESSReferenceString, PostCODE));
            SN.SignOut();
        }
        else if(Message.equalsIgnoreCase("mandatory"))
        {
            Assert.assertFalse(SN.AuthonticateUserMandatoryData(FirstName,LastName,Password,AD_FirstName,AD_LastName,AD_ADDRESS,AD_CITY,AD_MOBILEPHONE,AD_ADDRESSReferenceString,PostCODE));
            //verification for each mandatory validation msg
        }

    }

    @DataProvider
    public Object[][] EmailDP() throws Exception {

        /* Email
         * Case
         * message
         * System Message
         */

        ExcelReader.setExcelFile(System.getProperty("user.dir")+"\\Data\\UserAccount.xlsx","NewAccount");
        Object[][] object= new Object[ExcelReader.getNumberOfRows()-1][ExcelReader.getNumberOfColumns()];

        for (int i=1; i<ExcelReader.getNumberOfRows();i++)
        {
            for(int j=0;j<ExcelReader.getNumberOfColumns();j++)
            {
                object[i-1][j]=ExcelReader.getCellData(i,j);
            }
        }
        return object;
    }

    @DataProvider
    public Object[][] AuthenticationDP() throws Exception {

        /* Cass	Message
         * FirstName
         * LastName
         * Email
         * Password
         * AD_FirstName
         * AD_LastName
         * AD_COMPANY
         * AD_ADDRESS
         * AD_CITY
         * PostCODE
         * AD_ADDITIONALINFO
         * AD_HOMEPHONE
         * AD_MOBILEPHONE
         * AD_ADDRESSRefrence
         */

        ExcelReader.setExcelFile(System.getProperty("user.dir")+"\\Data\\UserAccount.xlsx","Authontication");
        Object[][] object= new Object[ExcelReader.getNumberOfRows()-1][ExcelReader.getNumberOfColumns()];

        for (int i=1; i<ExcelReader.getNumberOfRows();i++)
        {
            for(int j=0;j<ExcelReader.getNumberOfColumns();j++)
            {
                object[i-1][j]=ExcelReader.getCellData(i,j);
            }
        }
        return object;
    }
}
