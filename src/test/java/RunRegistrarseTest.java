import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/FormulariRegistrarse.feature", glue="steps")
public class RunRegistrarseTest extends AbstractTestNGCucumberTests{

}
