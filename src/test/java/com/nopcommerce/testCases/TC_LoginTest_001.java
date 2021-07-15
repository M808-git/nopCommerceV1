package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.*;

public class TC_LoginTest_001 extends BaseClass{
	
		
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		driver.get(baseURL);		
		
		//
		LoginPage lp = new LoginPage(driver);
		
		logger.info("username provided");
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		logger.info("Submitted login");
		
		Thread.sleep(8000);
		
		if(driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			
			Assert.assertTrue(true);
			logger.info("login pass");
					
		}
		
		else
		{
			
			captureScreen(driver,"TC_LoginTest_001");
			Assert.fail("Login failed, please check username and password");
			
			logger.info("Login failed, please check username and password");
		}
	
	}
	
	
	
		
		
	}
	
	
	


