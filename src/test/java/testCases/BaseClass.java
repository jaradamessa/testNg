package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	RemoteWebDriver driver;

	private ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();

	@BeforeMethod
	public void SetUp() throws MalformedURLException {

		String DriverType = System.getProperty("Browser");
		
		if (DriverType.contains("firefox")) {
			driver = new FirefoxDriver();
			//DriverType.contains("firefox")
		} 
		
		else if (DriverType.contains("remote")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-dev-shm-using") ;
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--headless") ;
			driver = new RemoteWebDriver(new URL("http:// 18.207.217.4:4444"),options);
			/*
			 * DesiredCapabilities cap = new DesiredCapabilities();
			 * cap.setPlatform(Platform.WIN11);
			 *  cap.setBrowserName("chrome");
			 *   driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			 */
		}

		else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-dev-shm-using") ;
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--headless") ;
			driver = new ChromeDriver(options);
		
					
		}

		SetDriver(driver);
		GetDriver().get("https://simplilearn.com/");
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@AfterMethod
	public void TearDown() {

		GetDriver().close();

	}

	public void SetDriver(RemoteWebDriver driver) {

		threadLocalDriver.set(driver);

	}

	public RemoteWebDriver GetDriver() {

		return threadLocalDriver.get();

	}

}
