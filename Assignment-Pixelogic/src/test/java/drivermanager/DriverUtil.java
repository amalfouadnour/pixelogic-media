package drivermanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;

/**
 * * Helper Class for reading properties * It is just a very basic
 * implementation
 */
public final class DriverUtil {
	private static final Logger LOG = LoggerFactory.getLogger(DriverUtil.class);
	
	private static WebDriver driver;
	private static String targetWebUIUrl;
	private static String targetRestApiUrl;

	private static String browser = "chrome";
	public static long DEFAULT_WAIT = 20;

	private DriverUtil() {
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getTargetWebUrl() {
		return targetWebUIUrl;
	}

	public static String getTargetRestUrl() {
		return targetRestApiUrl;
	}

	public static String getBrowser() {
		return browser;
	}

	public static WebDriver initDriver() throws MalformedURLException  {
		 System.setProperty("webdriver.chrome.driver", "src\\test\\java\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		return driver;
	}

	private static DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities ret = null;

		String preferredDriver = getBrowser().toLowerCase();

		switch (preferredDriver.toLowerCase()) {
		case "safari":
			ret = DesiredCapabilities.safari();
			break;
		case "msie":
			ret = DesiredCapabilities.internetExplorer();
			break;
		case "edge":
			ret = DesiredCapabilities.edge();
			break;
		case "chrome":
			ret = DesiredCapabilities.chrome();
			break;
		default:
			ret = DesiredCapabilities.firefox();
			break;

		}
		return ret;
	}
	
	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.quit();
				driver = null;
			} catch (NoSuchMethodError | NoSuchSessionException | SessionNotCreatedException ex) {
				// LOG.error("An error occured while closing the driver: ", ex);
			}
		}
	}

	public static boolean isFirefox() {
		return driver != null && "firefox".equals(getBrowser().toLowerCase());
	}

	public static boolean isChrome() {
		return driver != null && "chrome".equals(getBrowser().toLowerCase());
	}

	public static boolean isMsIe() {
		return driver != null && "msie".equals(getBrowser().toLowerCase());
	}

	public static boolean isEdge() {
		return driver != null && "edge".equals(getBrowser().toLowerCase());
	}
}
