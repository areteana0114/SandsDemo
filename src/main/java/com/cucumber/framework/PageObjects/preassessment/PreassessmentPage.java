package com.cucumber.framework.PageObjects.preassessment;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cucumber.framework.CS.CustomerServ;
import com.cucumber.framework.helper.Logger.LoggerHelper;

public class PreassessmentPage extends CustomerServ implements PreassessmentPageLoc{
	private final Logger log = LoggerHelper.getLogger(PreassessmentPage.class);
	PreassessmentPage preassessmentpage;
	
	public PreassessmentPage(WebDriver driver) {
		super(driver);
		}

	public void testPreassessmentPage() {
		//System.out.println("In TestLoginPage method :"+ driver);
	}
	
	public void sendPreassessmentObject(PreassessmentPage preassessmentpage) {
		this.preassessmentpage=preassessmentpage;
		//System.out.println("In sendPreassessmentObject method page"+this.preassessmentpage);
	}
	
	public void clickOnCreateMenuButton() {
		WebElement create_button=driver.findElement(By.xpath(create_button_xpath));
		preassessmentpage.waitForElement(create_button, 3);
		create_button.click();
	    waitFor(2);
	}
	
	public void clickOnPreassessmentButton() {
		WebElement preassessment_button=driver.findElement(By.xpath(preassessment_button_xpath));
		preassessmentpage.waitForElement(preassessment_button, 3);
		preassessment_button.click();
	    waitFor(2);
	}
	
	public void verifyUserInPreassessPage() {
		preassessmentpage.goToFrameByName("PegaGadget1Ifr");
	/*	WebElement fname=driver.findElement(By.xpath(preassessment_page_xpath));
		preassessmentpage.goToFrame(fname);*/
		Assert.assertTrue(driver.findElement(By.xpath(preassessment_page_xpath)).isDisplayed(), "Pre-Assessment Page is not displayed");
		waitFor(2);
	}
	
	public void enterFirstName() {
		WebElement firstname_txtbox=driver.findElement(By.xpath(firstname_xpath));
		preassessmentpage.waitForElement(firstname_txtbox, 3);
		firstname_txtbox.sendKeys("John");
	    waitFor(5);
	}
	
	public void enterLastName() {
		WebElement lastname_txtbox=driver.findElement(By.xpath(lastname_xpath));
		preassessmentpage.waitForElement(lastname_txtbox, 3);
		lastname_txtbox.sendKeys("Smith");
	    waitFor(3);
	}
	
	public void selectSmokerStatus() {
		preassessmentpage.clickOnSelectedElement(smokerstatus_xpath, 2);
		 waitFor(2);
	}
	
	public void selectAdviserName(String advisername) {
		WebElement adviser_txtbox=driver.findElement(By.xpath(adviser_name_xpath));
		preassessmentpage.waitForElement(adviser_txtbox, 3);
		adviser_txtbox.sendKeys(advisername);
	    waitFor(3);
		
	}
	
	public void enterTextIntoDisclosure() {
		WebElement disclosure_txtbox=driver.findElement(By.xpath(disclosure_xpath));
		preassessmentpage.waitForElement(disclosure_txtbox, 3);
		disclosure_txtbox.sendKeys("Retail LOB for Life");
	    waitFor(3);
	}
	
	public void selectBenefitLife() {
		WebElement benefit_chkbox=driver.findElement(By.xpath(life_xpath));
		preassessmentpage.waitForElement(benefit_chkbox, 3);
		benefit_chkbox.click();
	    waitFor(2);
	}
	
	public void selectMakeDecisionValue(String makedecisionvalue) {
		WebElement makedecision_dropdown=driver.findElement(By.xpath(make_decision_xpath));
		preassessmentpage.waitForElement(makedecision_dropdown, 3);
		preassessmentpage.selectFromDropdownUsingVisibleText(make_decision_xpath, makedecisionvalue);
	    waitFor(4);
	}
	
	public void selectDecision(String decisionvalue) {
		WebElement decision_dropdown=driver.findElement(By.xpath(decision_xpath));
		preassessmentpage.waitForElement(decision_dropdown, 3);
		preassessmentpage.selectFromDropdownUsingVisibleText(decision_xpath, decisionvalue);
	    waitFor(2);
	}
	
	public void enterSumInsured(String sum) {
		WebElement suminsured_txtbox_life=driver.findElement(By.xpath(suminsuredlife_xpath));
		preassessmentpage.waitForElement(suminsured_txtbox_life, 3);
		suminsured_txtbox_life.sendKeys(sum);
	    waitFor(2);
	}

	public void clickOnCreateBtn() {
		WebElement create_button=driver.findElement(By.xpath(create_btn_xpath));
		preassessmentpage.waitForElement(create_button, 3);
		create_button.click();
	    waitFor(2);
	}
	
	public void verifyCaseStatus(String status) {
		WebElement case_status=driver.findElement(By.xpath(case_status_xpath));
		preassessmentpage.waitForElement(case_status, 3);
		Assert.assertTrue(case_status.getText().equals(status), "status of the case is "+case_status.getText());
	    waitFor(3);
	    System.out.println(case_status.getText());
	}
}
