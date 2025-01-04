import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/ModifyCartQuantity.feature", glue="steps")
public class ModifyCartQuantityTest extends AbstractTestNGCucumberTests{

}
