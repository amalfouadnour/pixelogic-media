package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This class is used for running the cucumber tests. By default all feature
 * files and scenarios under src/test/java/acceptancetests/features are taken
 * under consideration. This is where the scenarios for local tests (e.g. by the
 * developers should be placed.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Feature" }, glue = {
		"steps" }, plugin = { "json:target/cucumber-reports/cucumber.json",
				"html:target/site/cucumber-pretty", "junit:target/cucumber-reports/Cucumber.xml" }, monochrome = true)
public class TestRunner {
}