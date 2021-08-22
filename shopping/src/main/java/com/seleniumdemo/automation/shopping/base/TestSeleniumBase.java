package com.seleniumdemo.automation.shopping.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.seleniumdemo.automation.shopping.utils.TestUtils;

public class TestSeleniumBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestSeleniumBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/seleniumdemo/automation/shopping/config/config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	public static void initialization()
	{
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", TestUtils.PROJECT_PATH + "/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("safari"))
		{
			// We can add more browser support here later
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}


}
