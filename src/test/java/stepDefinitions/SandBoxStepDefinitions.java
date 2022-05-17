package stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.JsCommonMethods;

public class SandBoxStepDefinitions extends CommonMethods{
	
	@Given("select the {string}")
	public void select_the(String choise) throws Throwable {
	
		JsCommonMethods.scrollDown(150);
		List<WebElement> Selections1 = sandBoxElements.groupHeaderDropDown;
		
		for(WebElement selection : Selections1) {
			
			if (selection.getText().equalsIgnoreCase(choise)) {
				JsCommonMethods.drawRedBorder(selection);
				
				selection.click();
				}
			break;
		}}
	@When("select {string} fill out to {string}, {string}, {string} and {string} and click submit btn")
	public void select_fill_out_to_and_and_click_submit_btn(String selection, String fullName, String email, String currentAdress, String permanentAdress) throws InterruptedException {
	  
	List<WebElement>  Selections2 = sandBoxElements.menuListDropDown;
	for(WebElement Selection : Selections2) {
		if(Selection.getText().equalsIgnoreCase(selection)) {
			Selection.click();
		}
		break;
	}
	Thread.sleep(1000);
		CommonMethods.sendKeys(sandBoxElements.userNameTextBox, fullName);
	    CommonMethods.sendKeys(sandBoxElements.userEmailTextBox, email);
	    CommonMethods.sendKeys(sandBoxElements.currentAddressTextBox, currentAdress);
	    CommonMethods.sendKeys(sandBoxElements.permanentAddressTextBox, permanentAdress);
	    JsCommonMethods.scrollDown(200);
	    
	    sandBoxElements.submitButn.click();
	    }
	
	@Then("assert text from output {string}, {string}, {string} and {string}")
	public void assert_text_from_output_and(String fullName, String email, String currentAdress, String permanentAdress) {
		
		
//		List<String> expect = new ArrayList<String>();
//		expect.add("Name:" + fullName);
//		expect.add("Email:" + email);
//		expect.add("Current Address :" + currentAdress);
//		expect.add("Permananet Address :" + permanentAdress);
	//	String a = fullName + email + currentAdress + permanentAdress;
		
		List<String> act = new ArrayList<String>();
		List<WebElement>  result = sandBoxElements.outputFromResult;
		for(WebElement result2:result) {
			
			act.add(result2.getText());
			
		}
		 String res = String.join("", act);
		
		
		 Assert.assertTrue(
							res.contentEquals("Name:" +  fullName +"Email:"+ email+"Current Address :" + currentAdress+ "Permananet Address :" + permanentAdress));
		
}
	
	@When("navigate {string}")
	public void navigate(String string) throws Throwable {
		
	 
		List<WebElement>  Selections2 = sandBoxElements.menuListDropDown;

		
		for(WebElement Selection : Selections2) {
			JsCommonMethods.scrollIntoView(Selection);
			if(Selection.getText().equalsIgnoreCase(string)) {
		
				Selection.click();
				break;
			}}
		Thread.sleep(1000);
	}
	
	@Then("select iconExpandClose then click on {string} and  {string} then assert text {string}")
	public void select_iconExpandClose_then_click_on_and_then_assert_text(String string1, String string2, String string3) throws Throwable {
	  
		click(sandBoxElements.iconExpandClose);
	
		CommonMethods.selectValueFromBootStrapDropDown(sandBoxElements.titleCheckBox, string1);
		CommonMethods.selectValueFromBootStrapDropDown(sandBoxElements.titleCheckBox, string2);
		
		List<String> act = new ArrayList<String>();
		
		List<WebElement> text = sandBoxElements.textFfromResult;
		for(int e = 0; e < text.size(); e++) {
		act.add(text.get(e).getText());
			
		}
		
		
		List<String> exp = new ArrayList<String>(Arrays.asList(string3));
		Thread.sleep(1000);
	
        String res = String.join("", exp);
		System.out.println(res);
		System.out.println(string3);
		
		Assert.assertTrue(
				res.contentEquals(string3));
		

	}
	@When("navigate to element group  {string}")
	public void navigate_to_element_group(String groups) throws Throwable {
		
	    List<WebElement> groupHeader = sandBoxElements.groupElement;
	    
//	    for(int e = 0; e< groupHeader.size(); e++) {
//	    	
//			if(groupHeader.get(e).getText().equals(groups)) {
//				groupHeader.get(e).click();
//				break;
//			}
//	    		
	    	

	    for(WebElement Selection : groupHeader) {
			JsCommonMethods.scrollIntoView(Selection);
			if(Selection.getText().equalsIgnoreCase(groups)) {
		
				Selection.click();
				break;
			}Thread.sleep(1000);
		}}
	@Then("click on tabButton")
	public void click_on_tabButton() {
	    sandBoxElements.tabButton.click();
	}
	
	@When("Window is open get text from page and assert with String {string}")
	public void Window_is_open_get_text_from_page_and_assert_with_String(String Text) {
	    CommonMethods.switchToChildWindow();
	    Assert.assertTrue(
				sandBoxElements.sampleHeading.getText().contentEquals(Text));
	}
	
	@Then("click on New Window")
	public void click_on_New_Window() {
	    click(sandBoxElements.newWindowButton);
	}
	@Then("click on click Me button  number fourth send {string} and assert this")
	public void click_on_click_Me_button_number_fourth_send_and_assert_this(String string) throws Throwable {
	    
		sandBoxElements.ClickMeButton4.click();
	    Thread.sleep(2000);
	    Alert alert =  driver.switchTo().alert();
	    alert.sendKeys(string);
	    alert.accept();
	    Assert.assertTrue(
				sandBoxElements.promptResult.getText().contentEquals("You entered " + string));
	
	}
	
	@Then("draw red border on a first iFrame and draw blue border on second and get get text")
	public void draw_red_border_on_a_first_iFrame_and_draw_blue_border_on_second_and_get_get_text() {
	    CommonMethods.swithToFrame("frame1");
	    JsCommonMethods.drawRedBorder(sandBoxElements.iFrameSamplePage);
	    driver.switchTo().defaultContent();
	    CommonMethods.swithToFrame("frame2");
	    JsCommonMethods.scrollDown(300);
	    JsCommonMethods.drawBlueBorder(sandBoxElements.iFrameSamplePage);
	    System.out.println(sandBoxElements.iFrameSamplePage.getText() + " --> This is text from frame 2");
	    
	}
	
	
	}






	


	
	