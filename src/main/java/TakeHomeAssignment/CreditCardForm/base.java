package TakeHomeAssignment.CreditCardForm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties props;

	public WebDriver initializeDriver() throws IOException {
  props= new Properties();
	FileInputStream fis= new FileInputStream("D:\\Eclipse Projects\\CreditCardForm\\data.properties");
	props.load(fis);
	String browserName=props.getProperty("browser");
	if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "D:\\Eclipse Projects\\CreditCardForm\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}else if (browserName.equals("IE")) {
		// we write code for IE 
	}else {
		// we write code for Chrome
	}
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	return driver;
}
	public void getScreenshots(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot tss= (TakesScreenshot)driver;
		File source= tss.getScreenshotAs(OutputType.FILE);
		String destinationfile= System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationfile));
		
	}
}
