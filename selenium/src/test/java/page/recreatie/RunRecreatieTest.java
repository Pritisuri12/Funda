package page.recreatie;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Funda/Recreatie.feature", glue="page.recreatie")


public class RunRecreatieTest {
}
