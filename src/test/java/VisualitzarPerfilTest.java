import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/VisualitzarPerfil.feature", glue="steps")
public class VisualitzarPerfilTest extends AbstractTestNGCucumberTests{

}
