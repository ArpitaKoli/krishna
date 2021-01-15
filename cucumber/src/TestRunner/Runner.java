package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.Glue;
import gherkin.ast.Feature;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
			glue= {"stepDefinations"},
			tags= {"@HookTest"}
            )
            
public class Runner 
{
}