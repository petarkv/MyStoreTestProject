package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import resources.ExtentManager;

public class Base {
	
	public static Properties prop;
//	public static WebDriver driver;
	
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke", "Regression", "Sanity"})
//	public void beforeSuite() throws Throwable {
	public void loadConfig() throws Throwable {
		ExtentManager.setExtent();
		DOMConfigurator.configure("src/main/java/resources/log4j.xml");
		
		try {
			prop = new Properties();
//			System.out.println("Super Constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
//			System.out.println("driver: " + driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		// Get driver from ThreadLocalMap
		return driver.get();
	}
	
	//loadConfig method is to load the configuration
//	@BeforeTest(groups = {"Smoke", "Regression", "Sanity"})
//	public void loadConfig() {
//
//		try {
//			prop = new Properties();
////			System.out.println("Super Constructor invoked");
//			FileInputStream ip = new FileInputStream(
//					System.getProperty("user.dir")+"\\Configuration\\Config.properties");
//			prop.load(ip);
////			System.out.println("driver: " + driver);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
		
	public static void launchApp(String browserName) {
//		WebDriverManager.chromedriver().setup();
//		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			// Set Browser to ThreadLocalMap
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
			// Set Browser to ThreadLocalMap
			driver.set(new InternetExplorerDriver());
		}
		
//		driver.manage().window().maximize();
//		Action.implicitWait(driver, 10);
//		Action.pageLoadTimeOut(driver, 30);		
//		driver.get(prop.getProperty("url"));
		
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);		
		getDriver().get(prop.getProperty("url"));		
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
