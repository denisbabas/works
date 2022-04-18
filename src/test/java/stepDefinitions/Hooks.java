package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.BaseClass;
import utils.CommonMethods;

public class Hooks {

	@Before
	public void startTest() {
		BaseClass.setUp();
		System.out.println("Starting Test Execution...");
	}
	
	@After
	public void endTest(Scenario scenario)  {
		byte[] screenshot;
		if(scenario.isFailed()) {
			screenshot = CommonMethods.takeScreenshot("failed/" + scenario.getName());
		} else {
			screenshot = CommonMethods.takeScreenshot("passed/" + scenario.getName());;
		}
		
		scenario.attach(screenshot, "image/png", scenario.getName());
		
		BaseClass.tearDown();
		System.out.println("End Test...");
	}

}
