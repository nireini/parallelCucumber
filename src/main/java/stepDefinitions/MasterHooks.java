package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.sql.Timestamp;

import static pageObjects.DriverFactory.cleanupDriver;
import static pageObjects.DriverFactory.getDriver;


public class MasterHooks {

	@Before
	public void setup() throws Exception {
		getDriver();
	}

	@AfterStep
	public void captureExceptionImage(Scenario scenario) {
		if (scenario.isFailed()) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String timeMilliseconds = Long.toString(timestamp.getTime());

			byte[] screenshot = ((TakesScreenshot) getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", timeMilliseconds);
		}
	}

	@After
	public void tearDown() {
		cleanupDriver();
	}
}
