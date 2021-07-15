package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	//page elements
	
		@FindBy(name="userName")
	    WebElement txtUsername;

	    @FindBy(name="password")
	    WebElement txtPassword;

	    @FindBy(name="login")
	    WebElement btnSubmit;


        //@FindBy(linkText="sign-off")
	    @FindBy(name="t_signoff")
        WebElement lnkSingoff;
        
	 // action methods
	    
	    public void setUsername(String username) {
	    	
	    	txtUsername.sendKeys(username);
	    	
	    }
	    
	    
	    public void setPassword(String pwd) {
	      	
	    	txtPassword.sendKeys(pwd);
	    	
	    }

	    public void clickSubmit() {
	    	
	    	btnSubmit.click();
	    	
	    }
	    
	    
       public void clickSignoff() {
	    	
	    	lnkSingoff.click();
	    	
	    }




}
