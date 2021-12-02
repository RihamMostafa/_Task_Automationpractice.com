import Pages.HomePage;
import Pages.SignIn;
import properties.LoadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import Driver.Driver;
import org.testng.annotations.Test;

public class BaseTest {

	//public static Driver driver;


	@BeforeTest
	public void beforeTest(){
		//Driver.getDriver("Chrome");  //Firefox
		System.out.println("before test");
	}

	@BeforeClass
	public void BC()
	{
		Driver.getDriver("Chrome");//Firefox
		Driver.navigateTOURL(LoadProperties.URLS.getProperty("homeURL"));
		//HomePage HP= new HomePage();
	}

	@AfterClass
	public void SysOutA()
	{
		Driver.CloseDriver();
		System.out.println("AfterClass");

	}

}
