package com.nopcommerce.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtilsM;

public class LoginTestDataProvider {

	
	WebDriver driver;
	public static Logger logger;	
	
	
	@BeforeMethod
	 public void setUp() {
    	 
   	  System.out.println("Start test");
   	  System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver_win32//chromedriver.exe");
   	  driver = new ChromeDriver();
   	  String url = "https://www.google.com";
   	  driver.get(url);
   	  driver.manage().window().maximize();
   	 
	  }

	
	@Test(dataProvider="LoginData")
	
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		//public void loginTest() throws InterruptedException, IOException {
		
        driver.get("http://localhost:8080/mtours/servlet/com.mercurytours.servlet.WelcomeServlet");		
		driver.manage().window().maximize();
		Thread.sleep(8000);
		
		//logger
		
		logger = Logger.getLogger("Manju-inDataProviderTest");
		PropertyConfigurator.configure("log4j.properties");
		  
		//
		LoginPage lp = new LoginPage(driver);
		
		
		logger.info("username provided");
		lp.setUsername(user);
		
		lp.setPassword(pwd);
		logger.info("password provided");
		
		lp.clickSubmit();
		logger.info("Submitted login");
		
		Thread.sleep(8000);
		
		//lp.clickSignoff();
		//logger.info("User Signoff");
		
		
		if(driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			
			Assert.assertTrue(true);
			logger.info("login pass");
					
		}
		
		else
		{
			
			//captureScreen(driver,"LoginTestDataProvider");
			Assert.fail("Login failed, please check username and password");
			
			logger.info("Login failed, please check username and password");
		}
	
		
				
	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ("C://eclipse-workspace//nopCommerceV1//src//test//java//com//nopcommerce//testData//LoginData.xlsx");
		
		int rowCount= XLUtilsM.getRowCount();
		
		int cellCount = XLUtilsM.getCellCount(1);
		
		String logindata[][] = new String[rowCount][cellCount];
		
		for (int i=1;i<=rowCount;i++) {
			
			
			for (int j=0;j<cellCount;j++) {
				
			 logindata[(i-1)][j] = XLUtilsM.getCellData(i, j);
			 System.out.println("  Cell value is" + logindata[(i-1)][j].toString());
			}
			
		
		}
		
		return logindata;
		
		}
		

	@AfterMethod
  	public void burnDown(){
        	driver.quit();
  	}
	
	



}
