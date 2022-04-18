package utils;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.PageInitializer;

public class JsCommonMethods extends PageInitializer {
	/**
	 * Use this method in need of scrolling the page to a specific element.
	 * 
	 * @param wbe element to which you want to bring in to view.
	 */
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}


	/**
	 * Method return Object of JavaScript Executor type
	 * 
	 * @return js object
	 */
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * Method performs click using JavaScript executor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click();", element);
	}
	

	/**
	 * Use this method in need of generating alert in runtime while an issue raises.
	 * 
	 * @param object  of WebDriver.
	 * @param message Pass the message you want to generate.
	 */
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}
	
	/**
	 * Use this method in need of refreshing browser instance which is opened by
	 * selenium WebDriver.
	 * 
	 * @param driver Pass the object of WebDriver here.
	 */
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	/**
	 * Use this method in need of retrieving the page title.
	 * 
	 * @param driver pass the object of WebDriver here.
	 * @return string object.
	 */
	public static String getPageTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	/**
	 * Methods scrolls up using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0, -" + pixel + ")");
	}
	
	/**
	 * Methods scrolls down using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0," + pixel + ")");
	}
	/**
	 * Use this method in need of clearing WebElement internally. This is used when
	 * WebDriver is failed to clear a text box value.
	 * 
	 * @param web Element.
	 */
	public static void clearByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", element);
	}
	
	/**
	 * this method click on check boxes and radio button (if you wont click more then one parameter use table |    |       |
	 * @param radioOrCheckBoxes
	 * @param value
	 */
	
	public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value) {
		String actualValue;
		for (WebElement radioOrCheckBox : radioOrCheckBoxes) {
			actualValue = radioOrCheckBox.getAttribute("value").trim();
			if(radioOrCheckBox.isEnabled() && actualValue.equals(value)) {
				jsClick(radioOrCheckBox);
				break;
			}
			
		}
	}

	/**
	 * Use this method in need of sending text to a web element.
	 * 
	 * @param element
	 * @param value
	 */
	public static void enterValueByJS(WebElement element, String value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=value;");
	}
	
	/**
	 * Use this method in need of surrounding an element with blue border.
	 * 
	 * @param web element.
	 */
	public static void drawBlueBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
	}

	/**
	 * Use this method in need of surrounding an element with Red border.
	 * 
	 * @param element Pass the web element.
	 */
	public static void drawRedBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid Red'", element);
	}

	public static void clickRadioOrCheckBox(WebElement webElement, String value) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
	
