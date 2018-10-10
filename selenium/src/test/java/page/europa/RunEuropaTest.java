package page.europa;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Funda/Europe.feature", glue="page.europe")
public class RunEuropaTest {


}
