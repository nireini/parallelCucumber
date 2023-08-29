package pageObjects;

import enums.ByTypes;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Base_PO extends DriverFactory {

    private static String screenshotName;

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }



    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element)).click();
                //wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public WebElement WaitUntilWebElementIsVisibleUsingLocatorStringValue(ByTypes type, String value, int timeout, boolean mandatory) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));

        WebElement element = null;

        try {
            switch (type) {

                case xpath:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                    break;
                case className:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
                    break;

                case id:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
                    break;

                case link:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
                    break;

                case name:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
                    break;

                case css:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
                    break;
                default:
                    break;
            }

            System.out.println("Element is visible using By locator: " + "<" + value + ">");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("WebElement is NOT visible, using By locator: " + "<" + value + ">");

            if (mandatory == true) {
                Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            }
        }

        if (element == null && mandatory == true) {
            System.out.println("WebElement is NOT visible, using By locator: " + "<" + value + ">");

            Assert.fail("Mandatory element " + value + " was not found");
        }

        return element;

    }

    public void switchToFrameAndWaitForElement(WebElement element, ByTypes iframe_locator_type, String iframe_Locator) throws Exception
    {

        String currentWindow = getDriver().getWindowHandle();

        getDriver().switchTo().defaultContent();

        try
        {
            getDriver().switchTo().frame(WaitUntilWebElementIsVisibleUsingLocatorStringValue(iframe_locator_type, iframe_Locator, 40, true));

            WaitUntilWebElementIsVisible(element);

            getDriver().switchTo().window(currentWindow);
        }catch(NoSuchFrameException e)
        {
            throw new Exception(e.getMessage(), e);
        }
    }

    public boolean WaitUntilWebElementIsVisible(WebElement element) {

        int timeout = 40;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public void switchToFrameAndClickElement(ByTypes type, String element_value, String frame_id, Boolean waitForCommercial) throws Exception
    {
        String currentWindow = getDriver().getWindowHandle();

        int timeout = 40;

        WebElement element = null;

        getDriver().switchTo().defaultContent();

        try
        {
            if(waitForCommercial){
                Thread.sleep(35000);
            }

            getDriver().switchTo().frame(frame_id);

            switch (type) {
                case xpath:
                    element = WaitUntilWebElementIsVisibleUsingLocatorStringValue(ByTypes.xpath, element_value, timeout, true);
                    break;
                case css:
                    element = WaitUntilWebElementIsVisibleUsingLocatorStringValue(ByTypes.css, element_value, timeout, true);
                    break;
                default:
                    break;
            }

            element.click();

            getDriver().switchTo().window(currentWindow);
        }catch(NoSuchFrameException e)
        {
            throw new Exception(e.getMessage(), e);
        }
    }

    public String GetTextFromElementInsideIframeByCSS(String ELEMENT_CSS, String iframeID) throws Exception {

        WebElement Element = null;

        String ElementText = "";

        Integer timeout = 10;

        String currentWindow = getDriver().getWindowHandle();

        try
        {
            getDriver().switchTo().frame(iframeID);
        }catch(NoSuchFrameException e)
        {
            throw new Exception(e.getMessage(), e);
        }

        try
        {
            Element = WaitUntilWebElementIsVisibleUsingLocatorStringValue(ByTypes.css, ELEMENT_CSS, timeout, true);

            ElementText = Element.getText();


        } catch (Exception e)
        {
            e.printStackTrace();
        }

        getDriver().switchTo().window(currentWindow);

        return ElementText;
    }

    public String getCurrentDate(){

        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = currentDate.format(dateFormatter);

        System.out.println("Current date (formatted with month name): " + formattedDate);

        return formattedDate;
    }

    public static void captureScreenshot() throws IOException, InterruptedException {
        File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

        screenshotName = returnDateStamp(".jpg");

        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName));
    }

    public static String returnDateStamp(String fileExtension) {
        Date d = new Date();
        String date = d.toString().replace(":", "_").replace(" ", "_") + fileExtension;
        return date;
    }



    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String waitForWebElementAndGetText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String element_text = "";

        boolean gotText = false;
        int attempts = 0;
        while (!gotText && attempts < 10) {
            try {
                element_text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
                System.out.println("Successfully got text on the WebElement: " + "<" + element.toString() + ">");
                gotText = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and get text on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and get text on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
        return element_text;
    }

}
