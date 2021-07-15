package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception is " + e.getMessage());
		}
		
	}

	
	public String getApplicationURL() {
		
	String str = pro.getProperty("baseURL");
	return str;
		
		
	}
	
	public String getUsername() {
		
		String username = pro.getProperty("userName");
		return username;
					
		}
	
	
    public String getPassword() {
		
		String passwd = pro.getProperty("pwd");
		return passwd;
				
		}
	
	
    public String getChromePath() {
		
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
					
		}
    
    public String getIEPath() {
		
		String iepath = pro.getProperty("iepath");
		return iepath;
						
		}
    
    
    public String getFirefoxPath() {
		
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
			
			
		}
	
	
	

}
