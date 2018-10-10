package page.huur;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Funda/Huur.feature", glue="page.huur")

public class RunHuurTest {
}


