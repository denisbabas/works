package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class SandBoxElements extends BaseClass {
	
/**
 * Beginning Elements from 
 */
	
	                
	@FindBy(xpath = "//*[@class = 'card-body']")
	public List <WebElement> groupHeaderDropDown;
	
	@FindBy(xpath = "//*[@class ='menu-list']/li")
	public List <WebElement> menuListDropDown;
	
	@FindBy (id = "submit")
	public WebElement submitButn;
	
	@FindBy(id = "userName")
	public WebElement userNameTextBox;
	
	@FindBy(id = "userEmail")
	public WebElement userEmailTextBox;
	
	@FindBy(id = "currentAddress")
	public WebElement currentAddressTextBox;
	
	@FindBy(id = "permanentAddress")
	public WebElement permanentAddressTextBox;
	
	@FindBy (xpath = "//*[@class = 'border col-md-12 col-sm-12']/p")
	public List<WebElement> outputFromResult;
	
	/**
	 * End Elements from 
	 */
	
	
	public SandBoxElements() {
		
	    PageFactory.initElements(driver, this);
		}
}
