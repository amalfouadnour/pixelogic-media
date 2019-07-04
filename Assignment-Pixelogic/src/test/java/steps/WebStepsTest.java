package steps;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivermanager.DriverUtil;
import pages.BasePage;
import pages.RegisterationPage;
import cucumber.api.java8.En;




public class WebStepsTest implements En {
	
	static WebDriver driver;
	RegisterationPage registerationPage = new RegisterationPage(driver);
	BasePage basePage = new BasePage(driver);

	public WebStepsTest() {
		// Registeration full path
//__________________________________________________User register mail successfully_________________________________________________________________________
//		____________________________________________________________________________________________________________________________
			Given("User goes to logged in to the PHPtravels portal", () -> {
			driver = DriverUtil.getDriver();
			driver.get("https://www.phptravels.net/register");
		});

		When("user enter first name", () -> {
			registerationPage.enterFirstName();
		});

		When("enter last name", () -> {
		    registerationPage.enterLastName();
		});

		When("enter mobile number", () -> {
		   registerationPage.enterMobile();
		});

		When("enter valid mail", () -> {
		    registerationPage.enterGmail();
		});

		When("enter valid password", () -> {
		    registerationPage.enterPassword();
		});

		When("enter confirmation for password", () -> {
		    registerationPage.enterConfirmPassword();
		});

		When("clicks on sign up button", () -> {
			registerationPage.clickGotItBtn();
			
		    registerationPage.clickOnSignUpBtn();
		});

		Then("user is navigated to another page", () -> {
		    String expectedURL = "https://www.phptravels.net/account/";
		    Thread.sleep(2000);
		    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
		});

//______________________________________________________User registers already un existing mail__________________________________________________________________
		
		When("enter an already registered mail mail", () -> {
			registerationPage.enterExistingGmail();
		});

		Then("and error appears that the mail is already registered", () -> {
			 String expectedURL = "https://www.phptravels.net/ddddddd/";
			    Thread.sleep(2000);
			    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
			//basePage.takeSnapShot(driver, "target/site/screenshot.png") ;
		});
		
	}	
}
	
