package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtilsM;

public class TC_LoginTestDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user , String pwd) throws InterruptedException, IOException {
		
        driver.get(baseURL);		
		driver.manage().window().maximize();
		Thread.sleep(8000);
		//
		LoginPage lp = new LoginPage(driver);
		
		
		logger.info("username provided");
		lp.setUsername(user);
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		logger.info("Submitted login");
		
		Thread.sleep(8000);
		
		if(driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			
			Assert.assertTrue(" Login passed", true);
			logger.info("login pass");
					
		}
		
		else
		{
			
			captureScreen(driver,"TC_LoginTestDDT_002");
			Assert.assertTrue("Login failed, please check username and password", false);
			//Assert.fail("Login failed, please check username and password");
			
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
		
	

}
	
	


