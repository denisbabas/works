package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import groovyjarjarantlr4.v4.parse.BlockSetTransformer.setAlt_return;
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
				System.out.println("textFromSelections = " + selection.getText());
				
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
		List<WebElement>  result = sandBoxElements.outputFromResult;
		
}
	}
