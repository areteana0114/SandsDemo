package com.cucumber.framework.stepDef.preassessment;

import org.apache.log4j.Logger;

import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;
import com.cucumber.framework.PageObjects.LogoutPage;
import com.cucumber.framework.PageObjects.Pulse;
import com.cucumber.framework.PageObjects.preassessment.PreassessmentPage;
import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.Logger.LoggerHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PreassessmentTest {
	
	private final Logger log = LoggerHelper.getLogger(PreassessmentTest.class);
	PreassessmentPage preassessmentpage;
	
	@Given("^Click on create button$")
	public void click_on_create_button() throws Throwable {
		preassessmentpage=new PreassessmentPage(TestBase.getDriver());		
		preassessmentpage.sendPreassessmentObject(preassessmentpage);
		preassessmentpage.clickOnCreateButton();
		
	}

	@When("^Click on Pre-assessment button$")
	public void click_on_Pre_assessment_button() throws Throwable {
	    preassessmentpage.clickOnPreassessmentButton();
	}

	@Then("^New Pre-assessment page should be displayed$")
	public void new_Pre_assessment_page_should_be_displayed() throws Throwable {
	  
	}

	@When("^User enters firstname and lastname$")
	public void user_enters_firstname_and_lastname() throws Throwable {
	  
	}

	@When("^Selects Smoker status as \"([^\"]*)\"$")
	public void selects_Smoker_status_as(String arg1) throws Throwable {
	    
	}

	@When("^Adviser Name as \"([^\"]*)\"$")
	public void adviser_Name_as(String arg1) throws Throwable {
	    
	}

	@When("^Default line of business selected is Retail$")
	public void default_line_of_business_selected_is_Retail() throws Throwable {
	   
	}

	@When("^User enters disclosure$")
	public void user_enters_disclosure() throws Throwable {
	   
	}

	@When("^selects benefit as life$")
	public void selects_benefit_as_life() throws Throwable {
	    
	}

	@When("^Make Decision as \"([^\"]*)\"$")
	public void make_Decision_as(String arg1) throws Throwable {
	   
	}

	@When("^Decision as \"([^\"]*)\"$")
	public void decision_as(String arg1) throws Throwable {
	 
	}

	@When("^Enters Sum Insured under life as \"([^\"]*)\"$")
	public void enters_Sum_Insured_under_life_as(String arg1) throws Throwable {
	   
	}

	@When("^Clicks on Create button$")
	public void clicks_on_Create_button() throws Throwable {
	  
	}

	@Then("^status of the case should be \"([^\"]*)\"$")
	public void status_of_the_case_should_be(String arg1) throws Throwable {
	   
	}



}
