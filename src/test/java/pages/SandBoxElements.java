package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.errorprone.annotations.FormatMethod;

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
	
	@FindBy (xpath = "//*[@class ='rct-icon rct-icon-expand-close']")
	public WebElement iconExpandClose;
	
	@FindBy(xpath = "//*[@class ='rct-title']")
	public List<WebElement>  titleCheckBox;
	
	
	@FindBy(xpath = "//*[@class ='display-result mt-4']/span")
	public List<WebElement>  textFfromResult;
	
	/**
	 * End Elements from 
	 */
	
	
	public SandBoxElements() {
		
	    PageFactory.initElements(driver, this);
		}
}
