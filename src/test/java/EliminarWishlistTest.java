import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/EliminarWishlist.feature", glue="steps")
public class EliminarWishlistTest extends AbstractTestNGCucumberTests{

}
