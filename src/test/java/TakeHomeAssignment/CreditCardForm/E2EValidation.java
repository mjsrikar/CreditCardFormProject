package TakeHomeAssignment.CreditCardForm;

import static org.testng.Assert.assertEquals;

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

public class E2EValidation extends base{
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
		Assert.assertEquals(driver.getTitle(), "Credit Card Form");
		//validating all fields are present in the form
		cobj.getcardName().sendKeys("e2eusername");
		Assert.assertEquals(cobj.getcardName().getText(), "e2eusername");
		cobj.getcardNumber().sendKeys("1000 2000 3300 4400");
		cobj.getcardType().sendKeys("AmericanExpress");
		cobj.getcvv().sendKeys(String.valueOf("100"));
		cobj.getexpMonth().sendKeys(String.valueOf("10"));
		cobj.getexpYear().sendKeys(String.valueOf("2025"));
		cobj.getzipcode().sendKeys(String.valueOf("60600"));
		cobj.getsubmitbutton().click();
		
	}
     
     
     @AfterTest
 	public void closebrowser() {
 		driver.close();
 	}
      
}
