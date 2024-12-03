import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/VisualitzarCategories.feature", glue="steps")
public class VisualitzarCategoriesTest extends AbstractTestNGCucumberTests{

}
