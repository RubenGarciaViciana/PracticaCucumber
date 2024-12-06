import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Logout.feature", glue="steps")
public class LogoutTest extends AbstractTestNGCucumberTests{

}
