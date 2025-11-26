package com.NaukriMaven;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class NaukriBase_Class {
	public static WebDriver driver;
	public static WebElement element;
	public static ExtentReports extentReports;
	public static File file;

	// 1.launch
	protected static void getBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("fireFox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");
		}
	}

	// 2.get url
	protected static void getUrl(String link) {
		try {
			driver.get(link);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING launch url");
		}
	}

	// 3.sendkeys
	protected static void passInput(WebElement element, String value) {
		try {
			element.sendKeys(value);

		} catch (Exception e) {
			Assert.fail("ERROR OCCUR DURING PASSINPUT");
		}
	}

	// 4.click
	protected static void Click(WebElement element) {
		try {
			element.click();

		} catch (Exception e) {
			Assert.fail("ERROR OCCUR DURING PASSINPUT");
		}
	}

	// 5.get title
	protected static void getTitle() {
		try {
			String getTitle = driver.getTitle();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING launch url");
		}
	}

	// 6.getcurrent url
	protected static void getCurrenturl() {
		try {
			String getCurrentUrl = driver.getCurrentUrl();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING launch url");
		}
	}

	// 7.NAVIGATE TO
	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING launch url");
		}
	}

	// 8.NAVIGATE forward
	protected static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING launch url");
		}
	}

	// 9.NAVIGATE back
	protected static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING launch url");
		}
	}

	// 10.NAVIGATE REFRESH
	protected static void navigateRefresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING launch url");
		}
	}

	// 11.quit
	protected static void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING QUIT");
		}
	}

	// 12.close
	protected static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLOSE");
		}
	}

//13.maximize
	protected static void maximize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING MAXIMIZE");
		}
	}

	// 14.minimize
	protected static void minimize() {
		try {
			driver.manage().window().minimize();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING MINIMIZE");
		}
	}

//15.to set the size
	protected static void setSize(int value, int value1) {
		try {
			Dimension d = new Dimension(value, value1);
			driver.manage().window().setSize(d);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING MINIMIZE");
		}
	}

//16.set position
	protected static void setPosition(int value, int value1) {
		try {
			Point d = new Point(value, value1);
			driver.manage().window().setPosition(d);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING MINIMIZE");
		}
	}

//17.findElement
	protected static void findElement(String type) {
		try {

			element = driver.findElement(By.id(type));
			element = driver.findElement(By.name(type));
			element = driver.findElement(By.className(type));
			element = driver.findElement(By.xpath(type));
			element = driver.findElement(By.tagName(type));
			element = driver.findElement(By.linkText(type));
			element = driver.findElement(By.partialLinkText(type));
			element = driver.findElement(By.cssSelector(type));
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING FINDELEMENT");
		}
	}

//18.enabled
//				protected static boolean isEnabled() {
//					try {
//					element.isEnabled();
//		            	}catch(Exception e) {
//						Assert.fail("ERROR : OCCUR DURING IS ENABLED");
//					}
//					return false;}					
	// 19.disabled
	protected static boolean isDisplayed() {
		try {
			element.isDisplayed();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING IS ENABLED");
		}
		return false;
	}

	// 20.is selected
	protected static boolean isSelected() {
		try {
			element.isSelected();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING IS  SELECTED");
		}
		return false;
	}

	// 21.dropdown
	protected static void selectDropdown(WebElement element, String Type, String value) {
		try {
			Select select = new Select(element);
			if (Type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (Type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			} else if (Type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR OCCUR IN DROPDOWN");
		}
	}

	// 22.DESELECT
	protected static void deselectDropdown(WebElement element, String Type, String value) {
		try {
			Select select = new Select(element);
			if (Type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if (Type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			} else if (Type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			} else if (Type.equalsIgnoreCase("value")) {
				select.deselectAll();
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR OCCUR IN DROPDOWN");
		}
	}

	// 23.staticwait
	protected static void staticWait(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			Assert.fail("ERROR OCCUR IN DURATION");

		}
	}

//24.screenshot
	protected static void takeScreenshotFile(String location, String Filename, String Fileformat) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(location + "\\" + Filename + "." + Fileformat);
			FileHandler.copy(src, des);
		} catch (WebDriverException e) {
			Assert.fail("ERROR OCCUR IN screenshot");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 25.GET OPTIONS
	protected static List<WebElement> getOption(WebElement element) {
		try {
			Select select = new Select(element);
			return select.getOptions();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING GET OPTIONS");
		}
		return null;
	}

	// 26.get text
	protected static void getText(WebElement element) {
		try {
			element.getAttribute(null);
			element.getText();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING TEXT");
		}
	}

	// 27.Handle Alert
	protected static void handleAlert(String email) {
		try {
			Alert alert = driver.switchTo().alert();
			if (email.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (email.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			} else {
				System.out.println(alert.getText());
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ALERT");
		}
	}

	// 28.Actions
	protected static void actionClickonElement(WebElement element1, WebElement element2) {
		try {
			Actions actions = new Actions(driver);
			actions.click().build().perform();
			actions.contextClick().build().perform();
			actions.doubleClick().build().perform();
			actions.dragAndDrop(element1, element2).build().perform();
			actions.moveToElement(element2).build().perform();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ACTIONS");
		}
	}

	// 29.selected
	protected static void selectBy(WebElement element, String type, int value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(value);
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(type);
			} else if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(type);
			} else {
				System.out.println("invalid select type:" + type);
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING DROPDOWN");
		}
	}

//30.multidown dropdown
	protected static void multidropDown(WebElement element, String type, int value) {
		try {
			Select select = new Select(element);
			select.selectByIndex(value);
			select.selectByValue(type);
			select.selectByVisibleText(type);
			select.deselectAll();
			select.deselectByIndex(value);
			select.deselectByValue(type);
			select.deselectByVisibleText(type);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING dropdown");
		}
	}

	// 31.KEYBASED ACTION
	protected static void keyBasedAction() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_3);
			r.keyRelease(KeyEvent.VK_3);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING KEYBASED ACTION");
		}
	}

	// 32..Get Attribute
	protected static String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	// 33
	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void extentReportTeamDown(String Location) throws IOException {
		extentReports.flush();
		file = new File(Location);
		Desktop.getDesktop().browse((file).toURI());
	}

	protected static String TakeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(newDate());
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		File desfile = new File("Screenshot\\.png" + "_" + timeStamp + ".png");
		FileHandler.copy(srcfile, desfile);
		return desfile.getAbsolutePath();
	}

	public static void javaScriptsendKeys(WebElement element, String value) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("arguments[0].click()", element);
	}

	public static void scrollUp(int pixels) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.ScrollBy(0," + pixels + ")", "");
	}

	public static void scrollDown(int pixels) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.ScrollBy(0,-" + pixels + ")", "");
	}

	public static void horizontalright(int pixels) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(arguments[],0)", pixels);

	}

	public static void extentReportStart1(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}

//	public String takeScreenshot() throws IOException {
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
//		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
//		FileHandler.copy(scrfile, destfile);
//		return destfile.getAbsolutePath();
//	}

	protected static Date newDate() {
		// TODO Auto-generated method stub
		return null;
	}

	protected static void validation(WebElement actual, String expected) {
		Assert.assertEquals(actual.getText(), expected);
		System.out.println(actual.getText());
	}

	// 33.implicitywait
	protected static void implicitylyWait(String Type, int valuesec) {
		try {
			if (Type.equalsIgnoreCase("seconds")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(valuesec));
			} else if (Type.equalsIgnoreCase("minute")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(valuesec));
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING DURATION");
		}
	}
}
