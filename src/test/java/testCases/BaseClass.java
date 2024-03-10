package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	
WebDriver driver;
	
	private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	@BeforeMethod
	public void SetUp() {

		String DriverType = System.getProperty("Browser");
		if (DriverType.contains("firefox")) {

			driver = new FirefoxDriver();

		} else {

			driver = new ChromeDriver();
		}
		
		SetDriver(driver);
		GetDriver().get("https://simplilearn.com/");
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	

	
		@AfterMethod
		public void TearDown() {

			GetDriver().close();

		}
		
		public void SetDriver(WebDriver driver) {

			threadLocalDriver.set(driver);

		}
		
		public WebDriver GetDriver() {

			return threadLocalDriver.get();

		}

	}

