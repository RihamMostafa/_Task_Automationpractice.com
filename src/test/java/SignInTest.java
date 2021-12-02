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


}
