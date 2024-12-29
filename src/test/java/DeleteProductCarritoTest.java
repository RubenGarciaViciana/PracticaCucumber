import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/DeleteProductCarrito.feature", glue="steps")
public class DeleteProductCarritoTest extends AbstractTestNGCucumberTests{

}
