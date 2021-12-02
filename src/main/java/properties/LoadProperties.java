package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties
{
	public static Properties URLS =
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\AppCredintials.properties");

	public static Properties SignIN =
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\SignIn.properties");

	public static Properties homepage =
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\homepage.properties");

	public static Properties WomenTab =
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\WomenTab.properties");

	public static  String propertiesFilePath;

	public static void setPath(String FileName)
	{
		propertiesFilePath =System.getProperty("user.dir")+"\\src\\main\\java\\properties\\"+FileName+".properties";
	}

	private static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		// stream for reading file 
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		}

		return pro;
	}
}
