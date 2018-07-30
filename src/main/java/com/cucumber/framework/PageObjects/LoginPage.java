package com.cucumber.framework.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.framework.CS.CustomerServ;
import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;
import com.cucumber.framework.helper.Logger.LoggerHelper;


public class LoginPage extends CustomerServ implements LoginPageLoc{
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	LoginPage loginpage;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		}

	public void testLoginPage() {
		//System.out.println("In TestLoginPage method :"+ driver);
	}
	
	public void sendLoginObject(LoginPage loginpage) {
		this.loginpage=loginpage;
		//System.out.println("In sendLoginObject method search page"+this.loginpage);
	}
	
	public LoginPage setUserName(String username) {
		WebElement username_txtbox=driver.findElement(By.xpath(username_xpath));
		loginpage.waitForElement(username_txtbox, 3);
		username_txtbox.sendKeys(username);
		//System.out.println("UserName" +driver);
		return new LoginPage(driver);
	}
	
	public LoginPage setPassword(String password ) {
		WebElement password_txtbox=driver.findElement(By.xpath(password_xpath));
		loginpage.waitForElement(password_txtbox, 3);
		password_txtbox.sendKeys(password);
		//System.out.println("Password" +driver);
		return new LoginPage(driver);
	}
	
	public void clickOnLoginbtn() {
		WebElement login_btn=driver.findElement(By.xpath(login_btn_xpath));
		loginpage.waitForElement(login_btn, 3);
		login_btn.click();
		//System.out.println("Clicked login button" +driver);
		loginpage.waitFor(5);
		try {
			WebElement loginclosebtn=driver.findElement(By.xpath(loginclosebtn_xpath));
	    	 waitForElement(loginclosebtn,2);
	    	 loginclosebtn.click();
	    }catch(Exception e) {
	    	System.out.println("No such element present");
	    }
		
	}
	
	public void verifyMsg() {
		
		Assert.assertTrue(driver.findElement(By.xpath(verify_msg_xpath)).getText().contains("UW Services"),"Login is not successful");	
		
	}
	
	public void verifyLoginFail() {
		
		Assert.assertTrue(driver.findElement(By.xpath(error_msg_xpath)).getText().contains("The information you entered was not recognized"),"User logged in");
	
	}

}
