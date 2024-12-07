import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/VeureWishlist.feature", glue="steps")
public class VeureWishlistTest extends AbstractTestNGCucumberTests{

}
