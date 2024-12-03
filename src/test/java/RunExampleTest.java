import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Example.feature", glue="steps")
public class RunExampleTest extends AbstractTestNGCucumberTests{

}
