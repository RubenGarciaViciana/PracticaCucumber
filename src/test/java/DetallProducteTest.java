import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/DetallProducte.feature", glue="steps")
public class DetallProducteTest extends AbstractTestNGCucumberTests{

}
