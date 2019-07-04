package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivermanager.DriverUtil;

import drivermanager.Extractor;

public class RegisterationPage {
	protected final WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), 10);

	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void enterFirstName() throws Exception{
		Extractor readFromExcel = new Extractor();
		WebElement firstName = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 0, 1)));
		firstName.sendKeys(readFromExcel.getExcelData("registrationPage", 8, 1));
	}
	
	public void enterLastName() throws Exception{
		Extractor readFromExcel = new Extractor();
		WebElement lastName = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 1, 1)));
		lastName.sendKeys(readFromExcel.getExcelData("registrationPage", 9, 1));
	}
	
	public void enterMobile() throws Exception{
		Extractor readFromExcel = new Extractor();
		WebElement mobile = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 2, 1)));
		mobile.sendKeys(readFromExcel.getExcelData("registrationPage", 10, 1));
	}
	
	public void enterGmail() throws Exception{
		Extractor readFromExcel = new Extractor();
		String stringName = ""+(int)(Math.random()*Integer.MAX_VALUE);
		String emailID = "User"+stringName+"@gmail.com";
		
		WebElement gmail = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 3, 1)));
		gmail.sendKeys(emailID);
	}
	public void enterPassword() throws Exception{
		Extractor readFromExcel = new Extractor();
		WebElement password = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 4, 1)));
		password.sendKeys(readFromExcel.getExcelData("registrationPage", 11, 1));
	}
	
	public void enterConfirmPassword() throws Exception{
		Extractor readFromExcel = new Extractor();
		WebElement confirmPassword = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 5, 1)));
		confirmPassword.sendKeys(readFromExcel.getExcelData("registrationPage", 11, 1));
	}
	
	public void clickOnSignUpBtn() throws Exception{
		Extractor readFromExcel = new Extractor();
		WebElement signUpBtn = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 6, 1)));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signUpBtn));
		signUpBtn.click();
	}
	
	public void clickGotItBtn() throws Exception{
		BasePage basePage = new BasePage(driver);
		Extractor readFromExcel = new Extractor();
		WebElement gotItBtn = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 7, 1)));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(closeCookies));
		gotItBtn.click();
	}
	
	
	public void enterExistingGmail() throws Exception{
		Extractor readFromExcel = new Extractor();
		
		WebElement gmailField = DriverUtil.getDriver().findElement(By.cssSelector(readFromExcel.getExcelData("registrationPage", 3, 1)));
		gmailField.sendKeys(readFromExcel.getExcelData("registrationPage", 12, 1));
	}

	
}