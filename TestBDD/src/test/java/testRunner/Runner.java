package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/Login.feature",
		glue="stepDefinitions",
		dryRun = false,
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports",
				"json:target/JSONReports/report.json",
				"junit:target/JUnitReports/report.xml"
		}
		)
public class Runner {

}
