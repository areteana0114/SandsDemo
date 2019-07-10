package com.cucumber.framework.stepDef.scheduleactivity;

import org.apache.log4j.Logger;

import com.cucumber.framework.PageObjects.preassessment.PreassessmentPage;
import com.cucumber.framework.PageObjects.scheduleactivity.ScheduleActivityPage;
import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.Logger.LoggerHelper;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ScheduleActivityTest {
	

	private final Logger log = LoggerHelper.getLogger(ScheduleActivityTest.class);
	ScheduleActivityPage scheduleactivitypage;

	@Then("^Click on New button$")
	public void click_on_New_button() throws Throwable {
		scheduleactivitypage=new ScheduleActivityPage(TestBase.getDriver());		
		scheduleactivitypage.sendScheduleActivityObject(scheduleactivitypage);
		scheduleactivitypage.clickOnNewButton();
	}
	
	@Given("^Hover On Demo Screen Pops$")
	public void hover_On_Demo_Screen_Pops() throws Throwable {
		scheduleactivitypage.HoverOnDemoScreenPops();
	}
	
	@Given("^Click on \"([^\"]*)\"$")
	public void click_on(String name) throws Throwable {
		scheduleactivitypage.clickOnDemoPop(name);
	}
	
	@Given("^Click on Accept$")
	public void click_on_Accept() throws Throwable {
		scheduleactivitypage.clickOnAcceptButton();
	}

	@Then("^System launches the interaction portal$")
	public void system_launches_the_interaction_portal() throws Throwable {
		scheduleactivitypage.verifyUserPageIsOpen();
	}

	@Given("^Click on Add Task button$")
	public void click_on_Add_Task_button() throws Throwable {
		scheduleactivitypage.clickAddTaskButton();
	}

	@Given("^select the \"([^\"]*)\" service case$")
	public void select_the_service_case(String servicecasename) throws Throwable {
		scheduleactivitypage.selectServiceCase(servicecasename);
	}

	@Given("^click on Add Tasks button$")
	public void click_on_Add_Tasks_button() throws Throwable {
		scheduleactivitypage.clickAddTasksButton();
	}

	@Given("^Click on Task$")
	public void click_on_Task() throws Throwable {
		scheduleactivitypage.clickOnTask();
	}
	


		@Given("^Select Task Type as \"([^\"]*)\" from Task  Type dropdown$")
		public void select_Task_Type_as_from_Task_Type_dropdown(String tasktype) throws Throwable {
			scheduleactivitypage.selectTaskType(tasktype);
		}

		@Given("^Select escalate as \"([^\"]*)\"$")
		public void select_escalate_as(String arg1) throws Throwable {
			scheduleactivitypage.selectEscalateAsNo();
		}

		@Given("^Select an  account \"([^\"]*)\" from link account dropdown$")
		public void select_an_account_from_link_account_dropdown(String account) throws Throwable {
			scheduleactivitypage.selectAccount(account);
		}

		@Given("^Select \"([^\"]*)\" from Assign to dropdown$")
		public void select_from_Assign_to_dropdown(String assignee) throws Throwable {
			scheduleactivitypage.selectAssignTo(assignee);
		}

		@Given("^Select \"([^\"]*)\" from the workbasket$")
		public void select_from_the_workbasket(String wb) throws Throwable {
			
			scheduleactivitypage.selectWorkbasket(wb);
		}

		@Given("^Enter \"([^\"]*)\" in note field$")
		public void enter_in_note_field(String comments) throws Throwable {
			scheduleactivitypage.enterNotes(comments);
		}

		@Given("^Click on Submit button$")
		public void click_on_Submit_button() throws Throwable {
			scheduleactivitypage.clickOnSubmit();
		}

		@Then("^verify  the message case has been created successfully$")
		public void verify_the_message_case_has_been_created_successfully() throws Throwable {
			scheduleactivitypage.verifyConfirmationMsg();
		}

		@Then("^Click on Confirm button$")
		public void click_on_Confirm_button() throws Throwable {
			scheduleactivitypage.clickOnConfirm();
		}

		@Then("^Click on Wrap Up$")
		public void click_on_Wrap_Up() throws Throwable {
			scheduleactivitypage.clickWrapUpButton();
			
		}

	
		@Given("^Click on My Workbaskets$")
		public void click_on_My_Workbaskets() throws Throwable {
			scheduleactivitypage.clickOnWB();
		}
	

		

		@And("^Open the required Case Id by clicking on \"([^\"]*)\" link$")
		public void open_the_required_Case_Id_by_clicking_on_link(String caseid) throws Throwable {
			scheduleactivitypage.clickWBResultsRow(caseid);
		}

		@Then("^Select \"([^\"]*)\" in Resolve work screen$")
		public void select_in_Resolve_work_screen(String arg1) throws Throwable {
			scheduleactivitypage.clickResolveRadiobtn();
		}

		@Given("^Click on Submit button in wrap up sccreen$")
		public void click_on_Submit_button_in_wrap_up_sccreen() throws Throwable {
			scheduleactivitypage.clickOnSubmitInWrapUpScreen();
		}

	


@Given("^Select \"([^\"]*)\" from the View Queue for workbasket$")
public void select_from_the_View_Queue_for_workbasket(String value) throws Throwable {
	scheduleactivitypage.clickOnWB();
	scheduleactivitypage.selectWB(value);
}




}
