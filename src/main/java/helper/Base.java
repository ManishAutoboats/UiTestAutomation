package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	static {
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/testData/env.properties");
			prop=new Properties();
			prop.load(file);
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Before
	public void setup() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
		}else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		}

	@After	
	public void tearDown(Scenario s) throws IOException {
		if(s.isFailed()) {
			 TakesScreenshot ts= (TakesScreenshot)driver;
		File ms=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ms, new File("screenshots"+s.getName()+".png"));
	
		}
	
			driver.quit();
			
			
						 
		}
	
	
	
	
	public void SelectBootstrapDown(List<WebElement>list,String expectedvalue) {
		for(WebElement e:list) {
			String value=e.getText();
			if(value.equals(expectedvalue)) {
				e.click();
				break;
				
			}
			
		}
		
	}
	 public void SelectByDropDown(WebElement ele,String value) {
		 Select s=new Select(ele);
		 s.selectByVisibleText(value);	 
		 
	 }
		
		 public void SelectByDropDown2(WebElement ele,int num) {
			 Select s=new Select(ele);
			 s.selectByIndex(num);
	
		}
		 
		 public void mousover(WebElement ele) {
			 Actions a=new Actions(driver);
			 a.moveToElement(ele).build().perform();
			 
			 
		 }
		 
		 public void javaScriptExecutorClick(WebElement ele) {
			
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("argument[o].click(),", ele);	 
			 
		 }
		 
		 public void explicitwaitForExpectedElement(WebElement ele) {
			 
			 WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
			 w.until(ExpectedConditions.visibilityOf(ele));
			 
			 
		 }
		 
		 public void selectAlertPopUp() {
			 
			 Alert a=driver.switchTo().alert();
			 a.accept();
		 }
		
}

