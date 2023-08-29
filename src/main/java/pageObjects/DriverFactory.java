package pageObjects;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.Constant.CHROME_DRIVER_DIRECTORY;
import static utils.Constant.GECKO_DRIVER_DIRECTORY;

public class DriverFactory {

	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		try{
			if (webDriver.get() == null) {
				webDriver.set(createDriver());
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		}
		return webDriver.get();
	}

	protected static WebDriver createDriver() {
		WebDriver driver = null;

		switch (getBrowserType()) {
			case "chrome" -> {
				System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_DIRECTORY);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver = new ChromeDriver(chromeOptions);
				break;
			}
			case "firefox" -> {
				System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_DIRECTORY);
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
				firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver = new FirefoxDriver(firefoxOptions);
				break;
			}
		}
		driver.manage().window().maximize();
		return driver;
	}

	private static String getBrowserType() {
		String useGrid = "false";
		String browserType = null;
		String browserTypeRemoteValue = System.getProperty("browserType");

		System.out.println("browserTypeRemoteValue: " + browserTypeRemoteValue);

		try {
			if (browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()) {
				Properties properties = new Properties();
				FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
				properties.load(file);
				browserType = properties.getProperty("browser").toLowerCase().trim();
			} else {
				browserType = browserTypeRemoteValue;
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return browserType;
	}

	public static void cleanupDriver() {
		webDriver.get().quit();
		webDriver.remove();
	}
}
