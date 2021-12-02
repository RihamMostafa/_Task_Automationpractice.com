package Driver;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;

public class Driver {
	
	public static WebDriver driver;
	//private static String ChromeDriverPath= System.getProperty("user.dir")+"\\src\\main\\java\\Drivers\\chromedriver.exe";
	//private static String GekoDriverPath= System.getProperty("user.dir")+"\\src\\main\\java\\Drivers\\geckodriver.exe";
	private static String DownloadsPath= System.getProperty("user.dir")+"\\Downloads";


	public static void HoverThenClick(WebElement we)
	{
		Actions action = new Actions(driver);
		//WebElement we = driver.findElement(By.xpath(xpath));
		action.moveToElement(we).moveToElement(we).click().build().perform();
	}
	
	public static void Hover(String xpath)
	{
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(xpath));
		action.moveToElement(we).build().perform();

	}

	public static String getCurrentUrl() 
	{
		return driver.getCurrentUrl().toString();
	}
	
	public static void navigateTOURL(String URL) 
	{
		driver.navigate().to(URL);
	}

	public static void submit(WebElement element) { element.submit(); }
	
	public static void click(WebElement element) { element.click(); }
	
	public static void clear(WebElement element) { element.clear(); }
	
	public static void settext(WebElement element, String Value) { element.sendKeys(Value); }
	
	public static String gettext(WebElement element) { return element.getText(); }

	public static WebElement findByXPath(String XPath)
	{
		return driver.findElement(By.xpath(XPath));
	}
	
	public static List<WebElement> findElementsByXPath(String XPath)
	{
		return driver.findElements(By.xpath(XPath));
	}
	
	
	public static void ScrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	public static void CloseDriver() {driver.close();}
	
	public static void getDriver(String browser) {
		
		if (browser=="Chrome")
		{
			 //System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
			 WebDriverManager.chromedriver().setup();
			 Map<String, Object> chromePreferences = new Hashtable<String, Object>();
			 chromePreferences.put("profile.default_content_settings.popups", 0);
			 chromePreferences.put("download.prompt_for_download", "false");
			 chromePreferences.put("download.default_directory",DownloadsPath);
			 ChromeOptions chromeOptions = new ChromeOptions();
			 chromeOptions.setExperimentalOption("prefs", chromePreferences);
			 chromeOptions.addArguments("disable-gpu");
			 ChromeOptions cap = new ChromeOptions();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			 cap.setCapability("resolution", "1024x768");
			 chromePreferences.put("plugins.always_open_pdf_externally", true);
			 driver= new ChromeDriver(cap);
			 Dimension d = new Dimension(1024,768);
			 //driver.manage().window().maximize();
			 driver.manage().window().setSize(d);
			 driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		
		}
		else if (browser=="Firefox")
		{
			//System.setProperty("webdriver.gecko.driver",GekoDriverPath);
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ffProfile = new FirefoxOptions();
			ffProfile.addPreference("browser.download.dir","");
			ffProfile.addPreference("browser.download.folderList", 2);
			ffProfile.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/zip,application/pdf,text/csv,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.openxmlformats-officedocument.wordprocessingml.document");

			ffProfile.addPreference( "browser.download.manager.showWhenStarting", false );
			ffProfile.addPreference( "pdfjs.disabled", true );
			ffProfile.addPreference("resolution", "1920x1080");
			driver=new FirefoxDriver(ffProfile);
			Dimension d = new Dimension(1024,768);
			//driver.manage().window().maximize();
			driver.manage().window().setSize(d);
			driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		
		}
		else if (browser=="InternetExplorer")
		{
			
		}
	}

	public static void select(WebElement element, String Selection)
	{
		  Select oSelect = new Select(element);
		  oSelect.selectByVisibleText(Selection);
	}

	public static void select(WebElement element, int Index)
	{
		Select oSelect = new Select(element);
		oSelect.selectByIndex(Index);
	}
	
}