package creditcardtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class SampleTest {
	public static void main(String args[]) {
	WebDriver driver;
	System.setProperty("Webdriver.gecko.driver", "D:\\Selenium Jars & Drivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.navigate().to("D:\\Eclipse Projects\\CreditCardForm\\creditcardv2.html");
	driver.findElement(By.xpath("//input[@id='cname']")).sendKeys("cname");//Name on the card
	//String actual= driver.findElement(By.xpath("//input[@id='cname']"));
    
	driver.findElement(By.xpath("//input[@id='ccnum']")).sendKeys("1100 2200 3300 4400"); //Credit card number
	driver.findElement(By.xpath("//input[@id='ctype']")).sendKeys("visa"); //Credit card type
	driver.findElement(By.xpath("//input[@id='expmonth']")).sendKeys("01"); //Exp Month
	driver.findElement(By.xpath("//input[@id='expyear']")).sendKeys("2022"); //Exp year
	driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("005"); //cvv
	driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("500005"); //zipcode

}
}
