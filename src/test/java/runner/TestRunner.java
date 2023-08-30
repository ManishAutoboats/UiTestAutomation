package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue= {"stepsDefinations", "helper"}, tags="@Reg" )
public class TestRunner {
	
	//Test Automation
	

}
