package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/resources/Features/Sogeti.feature",
glue={"StepDefinitions"},
plugin = {"pretty", "html:target/cucumber-reports.html"},
tags= "@smoke")
public class RunnerClass extends AbstractTestNGCucumberTests {

}
