import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/AfegirWishlist.feature", glue="steps")
public class AfegirWishlistTest extends AbstractTestNGCucumberTests{

}
