package TakeHomeAssignment.CreditCardForm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.math.BigInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjectsforform.CreditCardForm;

public class HomePage extends base{
	 public  WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest 
	public void openbrowser() throws IOException {
		driver=initializeDriver();
		driver.get(props.getProperty("url"));
		log.info("Initialized driver");
	}
	@Test
    public void navigatetoform() throws IOException {
		
		
		CreditCardForm cobj= new CreditCardForm(driver);
		String title= driver.getTitle();
		log.info("Navigated to Homepage");
		Assert.assertEquals(title, "Credit Card Form");
		log.info("Successfully validated Title of form");
	}
	
	@AfterTest
	public void closebrowser() {
		driver.close();
	}
}
