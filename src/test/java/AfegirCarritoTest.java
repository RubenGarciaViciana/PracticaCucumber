import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/AfegirCarrito.feature", glue="steps")
public class AfegirCarritoTest extends AbstractTestNGCucumberTests{

}
