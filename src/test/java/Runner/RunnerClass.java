package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/resources/Features/SogetiWeb.feature",
glue={"StepDefinitions"},
plugin = {"pretty", "html:target/reports.html"},
tags= "@test")
public class RunnerClass extends AbstractTestNGCucumberTests {

}
