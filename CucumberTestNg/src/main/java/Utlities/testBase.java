package Utlities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class testBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
//	public static ExtentHtmlReporter htmlReporter;
//	public static ExtentReports extend;
//	public static ExtentTest test;


	public testBase() {

		logger=Logger.getLogger("testBase");
		PropertyConfigurator.configure("Log4j.properties");
	//	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/testout/myreport.html");

//		htmlReporter.config().setDocumentTitle("Automation report");//Title of the report
//		htmlReporter.config().setReportName("Functional Report");//Name of the report
//		htmlReporter.config().setTheme(Theme.STANDARD);
//
//		extend=new ExtentReports();
//
//		extend.attachReporter(htmlReporter);
//
//		extend.setSystemInfo("Hostname", "LocalHost");
//		extend.setSystemInfo("TesterName", "Puneeth");
//		extend.setSystemInfo("BrowserName", "chrome");
//		extend.setSystemInfo("Machine", "Windows 10" + "64 Bit");
//		extend.setSystemInfo("Selenium", "3.141.59");
//		extend.setSystemInfo("Maven", "3.5.2");
//		extend.setSystemInfo("Java Version", "1.8.0_151");



		try {
			prop=new Properties();
			FileInputStream fls=new FileInputStream("E:\\E\\SampleProject\\Cucumber.POM\\src\\main\\java\\config\\confin.properties");
			prop.load(fls);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void initialization() {
		
		String browserName=prop.getProperty("Browse");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_path"));
			driver = new ChromeDriver();
			logger.info("************ Lanchink on chrome browser **********");
			//test.log(PASS, "Test Case (failTest) Status is passed");

		} else if(browserName.equals("ff")){
			driver=new FirefoxDriver();
			logger.info("************ Lanchink on FF browser **********");

		}

		driver.manage().window().maximize();
		logger.info("************ Maximize Browsr **********");

		driver.get(prop.getProperty("URL"));
		logger.info("************ Open the URL **********");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implecity_Wait, TimeUnit.SECONDS);

	}
}
