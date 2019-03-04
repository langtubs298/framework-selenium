package luong.vien.operation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {

	WebDriver driver;

	public UIOperation(WebDriver driver) {
		this.driver = driver;
	}

	public void perform(Properties p, String operation, String objectName, String objectType, String value, String message)
			throws Exception {
		System.out.println("");
		switch (operation.toUpperCase()) {
		case "CLICK":
			// Perform click
			driver.findElement(this.getObject(p, objectName, objectType)).click();
			break;
		case "SETTEXT":
			// Set text on control
			driver.findElement(this.getObjectWithoutProperties(objectName, objectType)).sendKeys(value);
			break;

		case "GOTOURL":
			// Get url of application
			driver.get(value);
			break;
		case "GETTEXT":
			// Get text of an element
			String messageText = driver.findElement(this.getObject(p, objectName, objectType)).getText();
			if(messageText.equals(message) ) {
				System.out.println(driver.findElement(this.getObject(p, objectName, objectType)).getText() + "---->Passed");
			}
			else {
				System.out.println(driver.findElement(this.getObject(p, objectName, objectType)).getText() + "---->Failed");
			}
			break;
		case "WAIT":
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} 
			break;

		default:
			break;
		}
	}

	/**
	 * Find element BY using object type and value
	 * 
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObject(Properties p, String objectName, String objectType) throws Exception {
		// Find by xpath
		if (objectType.equalsIgnoreCase("XPATH")) {

			return By.xpath(p.getProperty(objectName));
		}
		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(p.getProperty(objectName));

		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {

			return By.name(p.getProperty(objectName));

		}
		else if (objectType.equalsIgnoreCase("TAGNAME")) {

			return By.tagName(p.getProperty(objectName));

		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(p.getProperty(objectName));

		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {

			return By.linkText(p.getProperty(objectName));

		}
		else if (objectType.equalsIgnoreCase("ID")) {

			return By.id(p.getProperty(objectName));

		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(p.getProperty(objectName));

		}
		else {
			throw new Exception("Wrong object type");
		}
	}
	
	/**
	 * Find element BY using object type and value
	 * 
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObjectWithoutProperties(String objectName, String objectType) throws Exception {
		// Find by xpath
		if (objectType.equalsIgnoreCase("XPATH")) {

			return By.xpath(objectName);
		}
		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(objectName);

		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {

			return By.name(objectName);

		}
		else if (objectType.equalsIgnoreCase("TAGNAME")) {

			return By.tagName(objectName);

		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(objectName);

		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {

			return By.linkText(objectName);

		}
		else if (objectType.equalsIgnoreCase("ID")) {

			return By.id(objectName);

		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(objectName);

		}
		else {
			throw new Exception("Wrong object type");
		}
	}
}
