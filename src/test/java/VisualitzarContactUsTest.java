import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/VisualitzarContactUs.feature", glue="steps")
public class VisualitzarContactUsTest extends AbstractTestNGCucumberTests{

}
