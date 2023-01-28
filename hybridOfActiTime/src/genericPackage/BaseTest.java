package genericPackage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(CHROME_KEY, CHROME_VALUE);
		String url = flib.readPropertyData(PROP_PATH,"URL");
		
		if(browserValue.equals("chrome"))
		{
			System.setProperty(CHROME_KEY,CHROME_VALUE);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(url);
		}
		else if(browserValue.equals("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(url);
			
			
		}
		else
		{
			Reporter.log("enter valid browserValue",true);
		}
		
       public void failed(String methodName) {
    	   
       }
	
	}
}

