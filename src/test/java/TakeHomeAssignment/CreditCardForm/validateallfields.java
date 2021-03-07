package TakeHomeAssignment.CreditCardForm;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectsforform.CreditCardForm;

public class validateallfields extends base{
    public  WebDriver driver;
     public static Logger log= LogManager.getLogger(base.class.getName());
     @BeforeTest 
 	public void openbrowser() throws IOException {
 		driver=initializeDriver();
 		driver.get(props.getProperty("url"));
 		log.info("Navigated to form");
 	}
     @Test
	public void validateallfieldsdisplayed() throws IOException {
		
		CreditCardForm cobj= new CreditCardForm(driver);
		//validating all fields are present in the form
		Assert.assertTrue(cobj.getcardName().isDisplayed());
		Assert.assertTrue(cobj.getcardNumber().isDisplayed());
		Assert.assertTrue(cobj.getcardType().isDisplayed());
		Assert.assertTrue(cobj.getexpMonth().isDisplayed());
		Assert.assertTrue(cobj.getexpYear().isDisplayed());
		Assert.assertTrue(cobj.getcvv().isDisplayed());
		Assert.assertTrue(cobj.getzipcode().isDisplayed());
		Assert.assertTrue(cobj.getsubmitbutton().isDisplayed());
		log.info("successfully checked elements present on page");
	}
     
     @Test
 	public void validateallfieldsenabled() throws IOException {
 	
 		CreditCardForm cardobj= new CreditCardForm(driver);
 		//validating all fields are present in the form
 		Assert.assertTrue(cardobj.getcardName().isEnabled());
 		Assert.assertTrue(cardobj.getcardNumber().isEnabled());
 		Assert.assertTrue(cardobj.getcardType().isEnabled());
 		Assert.assertTrue(cardobj.getexpMonth().isEnabled());
 		Assert.assertTrue(cardobj.getexpYear().isEnabled());
 		Assert.assertTrue(cardobj.getcvv().isEnabled());
 		Assert.assertTrue(cardobj.getzipcode().isEnabled());
 		Assert.assertTrue(cardobj.getsubmitbutton().isEnabled());
 		log.info("Successfully checked elements are enabled on the page");
 	}
     
     @AfterTest
 	public void closebrowser() {
 		driver.close();
 	}
      
}
