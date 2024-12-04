import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/IniciarSessio.feature", glue="steps")
public class IniciarSessioTest extends AbstractTestNGCucumberTests{

}
