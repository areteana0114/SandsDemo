package com.cucumber.framework.PageObjects.preassessment;

public interface PreassessmentPageLoc {
	
	String create_button_xpath="//a[@aria-label='menu Create' and text()='Create']";
	String preassessment_button_xpath="//span[@class='menu-item-title' and text()='Pre-Assessment']";
	String preassessment_page_xpath="//input[@id='FirstName']";
	String firstname_xpath="//input[@id='FirstName']";
	String lastname_xpath="//input[@id='LastName']";
	String smokerstatus_xpath="//span[@class='col-2']";
	String adviser_name_xpath="//input[@id='AgreementNo']";
	String disclosure_xpath="//textarea[@id='CategoryDisclosure']";
	String life_xpath="//input[@id='pySelected2_rdi_2']";
	String make_decision_xpath="//select[@id='MakeDecision']";
	String decision_xpath="//select[@id='Decision']";
	String suminsuredlife_xpath="//input[@id='SumInsured']";
	String create_btn_xpath="//button[@title='Create this item']";
	String case_status_xpath="//a[@class='ellipsis']";
	String case_id_xpath="//span[@class='workarea_header_id']";
	String logpa_oper_xpath="//span[@class='supporting_text']";
	String logout_image_xpath="//a[@class='Header_nav']";
	String logoff_xpath="//span[@class='menu-item-title' and text()='Log off']";
	String searchtext_xpath="//input[@id='pySearchText' and @title='Enter text to search']";
	String logpaoperlink_xpath="//a[contains(text(),'Log PA Decision')]";
	String submitbtn_xpath="//button[text()='Submit']";

}
