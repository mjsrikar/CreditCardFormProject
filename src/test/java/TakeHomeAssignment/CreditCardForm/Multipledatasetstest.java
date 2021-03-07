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

public class Multipledatasetstest extends base{
	 public  WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest 
	public void openbrowser() throws IOException {
		driver=initializeDriver();
		log.info("Initialized driver");
		//driver.get(props.getProperty("url"));
	}

	
	@Test(dataProvider="getData")
    public void multipletestsets(String cardname, String cardnum, String cardtyp,int cvv, int expmon, int expyear,int zip ) throws IOException {
		driver.get(props.getProperty("url"));
		CreditCardForm cobj= new CreditCardForm(driver);
		cobj.getcardName().sendKeys(cardname);
		cobj.getcardNumber().sendKeys(cardnum);
		cobj.getcardType().sendKeys(cardtyp);
		cobj.getcvv().sendKeys(String.valueOf(cvv));
		cobj.getexpMonth().sendKeys(String.valueOf(expmon));
		cobj.getexpYear().sendKeys(String.valueOf(expyear));
		cobj.getzipcode().sendKeys(String.valueOf(zip));
        log.info("Multiple data set");
	}
	
	@DataProvider
	public Object[][] getData() {
		//rows for how many sets of data
		// columns are for how many values per test case
		Object[][] cardinfo=new Object[2][7];
		cardinfo[0][0]="Userone";
		cardinfo[0][1]="1111222233334444";
		cardinfo[0][2]="visa";
		cardinfo[0][3]=100;
		cardinfo[0][4]=11;
		cardinfo[0][5]=2022;
		cardinfo[0][6]=500007;
		//second set
		cardinfo[1][0]="Usertwo";
		cardinfo[1][1]="2222222233334444";
		cardinfo[1][2]="master card";
		cardinfo[1][3]=111;
		cardinfo[1][4]=01;
		cardinfo[1][5]=2025;
		cardinfo[1][6]=500010;
		return cardinfo;
	}
	
	@AfterTest
	public void closebrowser() {
		driver.close();
	}
}
