import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/VisualitzarCarrito.feature", glue="steps")
public class VisualitzarCarritoTest extends AbstractTestNGCucumberTests{

}
