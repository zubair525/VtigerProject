package com.Vtiger.genericlib;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the methods of WebDriver Interfaces with their
 * implementations to perform browser level actions.
 * 
 * @author zubairahmed
 *
 */
public class WebDriverUtilities {

	/**
	 * This method is used to wait till the entire web-page is fully loaded based on
	 * below parameters.
	 * 
	 * @param driver
	 * @param timeInSeconds
	 */
	public void waitTillPageIsLoaded(WebDriver driver, int timeInSeconds) {

		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to maximize the window of webPage.
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait till the element is clickable.
	 * 
	 * @param driver
	 * @param timeOutInSeconds
	 * @param element
	 */
	public void waitTillElementIsClickable(WebDriver driver, short timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to wait till element is visible.
	 * 
	 * @param driver
	 * @param timeOutInSeconds
	 * @param element
	 */
	public void waitTillElementIsVisible(WebDriver driver, short timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to wait till list of elements are visible.
	 * 
	 * @param driver
	 * @param timeOutInSeconds
	 * @param list
	 */
	public void waitTillListOfElementsVisible(WebDriver driver, short timeOutInSeconds, WebElement list) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}

	/**
	 * This method is used till the alert pop is displayed.
	 * 
	 * @param driver
	 * @param timeOutInSeconds
	 */
	public void waitTillAlertPopIsPresent(WebDriver driver, short timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * This method is used to select the option from dropDown based on index value.
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to select the option from dropDown based on visibleText.
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method is used to switch to the alert pop and click on ok.
	 * 
	 * @param driver
	 */
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to switch to the alert pop and click on cancel.
	 * 
	 * @param driver
	 */
	public void alertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to switch to the alert Pop up and capture text message.
	 * 
	 * @param driver
	 */
	public String alertCaptureText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	/**
	 * This method is used to handle the window based on entire or partial title.
	 * 
	 * @param driver
	 * @param expTitle
	 */
	public void switchToWindow(WebDriver driver, String expTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String windows : allWindows) {
			driver.switchTo().window(windows);
			String actTitle = driver.getTitle();
			try {
				actTitle.contains(expTitle);
				break;
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	public void switchToWindow(WebDriver driver) {
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
	}

	/**
	 * This method is used to traverse the mouse pointer on the specific element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform drag and drop action.
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used to perform mouse right click.
	 * 
	 * @param driver
	 */

	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method is used to switch to the frame based index value.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to the frame based webElement.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch to the frame based on id or name attribute
	 * value.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, String id, String name) {
		if (!(id != null)) {
			driver.switchTo().frame(id);
		} else if (name != null) {
			driver.switchTo().frame(name);

		}
	}

	/**
	 * This method is used to switch from any child frame to the main frame.
	 * 
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

}
