package Pages;

import Driver.Driver;
import properties.LoadProperties;

public class HomePage extends Driver {

    String URL;

    public HomePage(){

        URL= LoadProperties.homepage.getProperty("URL");
        if(!getCurrentUrl().equalsIgnoreCase(URL))
        {
            navigateTOURL(URL);
        }
    }

    public void SignIn()
    {
       click(findByXPath(LoadProperties.homepage.getProperty("SignIn_Btn")));
    }
    public void SignOut()
    {
        click(findByXPath(LoadProperties.homepage.getProperty("SignOut_Btn")));
    }
    public void ValidLogin()
    {
        SignIn();
        settext(findByXPath(LoadProperties.homepage.getProperty("Email_Txtbox")),
                LoadProperties.homepage.getProperty("ValidUser"));
        settext(findByXPath(LoadProperties.homepage.getProperty("Password_Txtbox")),
                LoadProperties.homepage.getProperty("password"));
        click(findByXPath(LoadProperties.homepage.getProperty("Submit_Btn")));
    }
}
