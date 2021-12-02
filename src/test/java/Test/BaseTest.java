package Test;

import properties.LoadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import Driver.Driver;

public class BaseTest {

	@BeforeTest
	public void beforeTest(){
		//Driver.getDriver("Chrome");  //Firefox
		System.out.println("before test");
	}

	@BeforeClass
	public void BC()
	{
		Driver.getDriver("Firefox");//Firefox
		Driver.navigateTOURL(LoadProperties.URLS.getProperty("homeURL"));
	}

	@AfterClass
	public void SysOutA()
	{
		Driver.CloseDriver();
		System.out.println("AfterClass");
	}
}
