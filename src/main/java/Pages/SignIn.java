package Pages;

import properties.LoadProperties;
import java.util.Random;

public class SignIn extends HomePage{

    public SignIn()
    {
        super();
        SignIn();
    }

    //Creating account 1st step: Email address screen.
    public void EmailAddress (String Email) throws InterruptedException {

        clear(findByXPath(LoadProperties.SignIN.getProperty("EmailAdress_txtbox")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("EmailAdress_txtbox")), Email);
        click(findByXPath(LoadProperties.SignIN.getProperty("CreateSubmit_Btn")));
        Thread.sleep(5000);
    }

    public boolean EmailPassedCases(String Email) throws InterruptedException {
        Random rand = new Random();
        int int_random = rand.nextInt(1000);
        EmailAddress(String.valueOf(int_random)+Email);
        return getCurrentUrl().contains(LoadProperties.SignIN.getProperty("redirect"));
    }

    public boolean EmailFailedCases(String Email,String Message) throws InterruptedException {
        EmailAddress(Email);
        if (getCurrentUrl().contains(LoadProperties.SignIN.getProperty("redirect"))) return false;
        return gettext(findByXPath(LoadProperties.SignIN.getProperty("EmailWarningMsg_txtOutput"))).trim()
                .equalsIgnoreCase(Message.trim());
    }

    public boolean AuthonticateUserMandatoryData(String FName,
                                              String LName,
                                              String Password,
                                              String AD_FNAME,
                                              String AD_LNAME,
                                              String Address,
                                              String City,
                                              String MPhone ,
                                              String alias,
                                              String PostalCode)
    {
        ScrollToElement(findByXPath(LoadProperties.SignIN.getProperty("FirstName")));
        clear(findByXPath(LoadProperties.SignIN.getProperty("FirstName")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("FirstName")), FName);

        clear(findByXPath(LoadProperties.SignIN.getProperty("LastName")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("LastName")), LName);

        Random rand = new Random();
        int int_random = rand.nextInt(1000);

        clear(findByXPath(LoadProperties.SignIN.getProperty("Password")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("Password")), String.valueOf(int_random)+Password);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_FirstName")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_FirstName")), AD_FNAME);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_LastName")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_LastName")), AD_LNAME);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_ADDRESS")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_ADDRESS")), Address);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_CITY")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_CITY")), City);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_MOBILEPHONE")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_MOBILEPHONE")), MPhone);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_ADDRESSReference")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_ADDRESSReference")), alias);

        clear(findByXPath(LoadProperties.SignIN.getProperty("PostCODE")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("PostCODE")), PostalCode);

        select(findByXPath(LoadProperties.SignIN.getProperty("AD_STATE")),"Texas");
        select(findByXPath(LoadProperties.SignIN.getProperty("AD_CONTURY")),"United States");

        click(findByXPath(LoadProperties.SignIN.getProperty("Regstration_Btn")));

        return getCurrentUrl().contains(LoadProperties.SignIN.getProperty("redirect"));

    }

    public void AuthenticateUserNonMandatoryData(String AD_COMPANY,String AD_ADDITIONALINFO,String AD_HOMEPHONE)
    {
        ScrollToElement(findByXPath(LoadProperties.SignIN.getProperty("AD_COMPANY")));
        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_COMPANY")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_COMPANY")), AD_COMPANY);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_ADDITIONALINFO")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_ADDITIONALINFO")), AD_ADDITIONALINFO);

        clear(findByXPath(LoadProperties.SignIN.getProperty("AD_HOMEPHONE")));
        settext(findByXPath(LoadProperties.SignIN.getProperty("AD_HOMEPHONE")), AD_HOMEPHONE);

        select(findByXPath(LoadProperties.SignIN.getProperty("DOB_Days")),(int)(Math.random()*(28-1+1)+1));
        select(findByXPath(LoadProperties.SignIN.getProperty("DOB_MONTH")),(int)(Math.random()*(12-1+1)+1));
        select(findByXPath(LoadProperties.SignIN.getProperty("DOB_YEAR")),
                String.valueOf((int)(Math.random()*(1999-1980+1)+1980))+"  ");

    }

}
