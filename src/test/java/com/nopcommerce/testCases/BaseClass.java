package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {
	
		 
	ReadConfig readConfig = new ReadConfig();
	 
		 		
			String baseURL = "http://localhost:8080/mtours/servlet/com.mercurytours.servlet.WelcomeServlet";
			//baseURL=readConfig.getApplicationURL();
			String username="mercury";
			//username=readConfig.getUsername();
			String password="mercury";
			//password=readConfig.getPassword();
	 
	 
	 public static WebDriver driver;
	
	 public static Logger logger;
	 
	 
	
	@BeforeTest
	@Parameters("browser")
	
	public void setup(String br ) {
		
		//logger
		
		logger = Logger.getLogger("Manju-nopCommerceV1");
		PropertyConfigurator.configure("log4j.properties");
				
		// driver
		
		if (br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		
       else if (br.equals("ie")) {
			
			
			System.setProperty("webdriver.ie.driver", "C://Selenium//IEDriverServer_Win32_3.150.1/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
        else if (br.equals("firefox")) {
			
			
			System.setProperty("webdriver.firefox.driver", "C://Selenium//geckodriver-v0.29.1-win64/gecko.exe");
			driver = new FirefoxDriver();
			
		}
	
		
	}
	
	
	@AfterTest
	public void close() {
		
		driver.close();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}

