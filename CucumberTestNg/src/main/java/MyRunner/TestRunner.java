package MyRunner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utlities.testBase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;

@RunWith(Cucumber.class)
@CucumberOptions(features="E:\\E\\SampleProject\\CucumberTestNg\\src\\main\\java\\Feature\\login.feature",//path of the feature file
glue= {"StepDefination"},//path of the step defination file
plugin= {"pretty",
		"html:target/cucumber-report/cucumber-pretty",
		"json:target/cucumber-report/CucumberTestReport.json",
		"rerun:target/cucumber-report/rerun.txt",
"json:target/cucumber-reports/CucumberTestReport.json"},

monochrome=true,//To display the console output in the proper readable format
strict=true,//it will check step is not define in step definition file
dryRun=false//to check the mapping is proper between feature file and step definition file
		)

public class TestRunner extends testBase {
	private TestNGCucumberRunner testNGcucumberrunner;

	@BeforeClass(alwaysRun=true)
	public void setUp() {
		testNGcucumberrunner=new TestNGCucumberRunner(this.getClass());
	}
	@Test(groups="cucumber",description="Runs Cucumber feature",dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberfeature) {
		testNGcucumberrunner.runCucumber(cucumberfeature.getCucumberFeature());	
	}
	@DataProvider
	public Object[][] features() {
		return testNGcucumberrunner.provideFeatures();
	}
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		testNGcucumberrunner.finish();
		//extend.flush();
	}
}
