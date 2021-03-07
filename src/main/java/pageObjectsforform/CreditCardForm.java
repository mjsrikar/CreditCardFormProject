package pageObjectsforform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreditCardForm {
	public CreditCardForm(WebDriver driver) {
		this.driver=driver;
	}
public WebDriver driver;

 By cardName=By.xpath("//input[@id='cname']");
 By cardNumber=By.xpath("//input[@id='ccnum']");
 By cardType=By.xpath("//input[@id='ctype']");
 By expMonth=By.xpath("//input[@id='expmonth']");
 By expYear=By.xpath("//input[@id='expyear']");
 By cvv=By.xpath("//input[@id='cvv']");
 By zipcode=By.xpath("//input[@id='zipcode']");
 By SubmitButton=By.xpath("//input[@class='btn']");
 
 public WebElement getcardName() {
	 return driver.findElement(cardName);
 }
 public WebElement getcardNumber() {
	 return driver.findElement(cardNumber);
 }
 public WebElement getcardType() {
	 return driver.findElement(cardType);
 }
 public WebElement getexpMonth() {
	 return driver.findElement(expMonth);
 }
 public WebElement getexpYear() {
	 return driver.findElement(expYear);
 }
 public WebElement getcvv() {
	 return driver.findElement(cvv);
 }
 public WebElement getzipcode() {
	 return driver.findElement(zipcode);
 }
 public WebElement getsubmitbutton() {
	 return driver.findElement(SubmitButton);
 }
}
