package steps;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import drivermanager.DriverUtil;
import pages.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	

	private static final Logger LOG = LoggerFactory.getLogger(Hook.class);

	@Before
	public void InitializeTest(Scenario scenario) throws MalformedURLException, InterruptedException {
		LOG.info("Starting Scenario: " + scenario.getName());

		// if the test is not marked as web test then no selenium driver is needed
//		if (!(scenario.getSourceTagNames().contains("@") || scenario.getSourceTagNames().contains("@"))) {
//			return;
//		}

		RemoteWebDriver driver = (RemoteWebDriver) DriverUtil.initDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//LOG.info("Video URL: http://cvm22419.bmwgroup.net/videos/" + driver.getSessionId() + ".mp4");
		//LOG.info("Live View URL: http://cvm22419.bmwgroup.net/ui/liveview?session=" + driver.getSessionId().toString());

	}
	
	 private  void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }

	@After
	public void TearDownTest(Scenario scenario) {
        WebDriver driver = DriverUtil.getDriver();
        if (scenario.isFailed()) {
            String fileName = "target/site/"+scenario.getName()+"-screenshot.png";
        	try {
				takeSnapShot(driver, fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            LOG.error("Failed scenario: " + scenario.getName());
        } 
		DriverUtil.closeDriver();
	}
}
