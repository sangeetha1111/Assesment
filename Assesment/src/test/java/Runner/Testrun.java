package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features/UI.feature"},
                glue= {"stepdefinition"},
                tags= "@tag1",
                plugin= {"pretty","html:target/cucumber-reports/report.html"},
                publish=true

                
               

		
		)


public class Testrun {

}
