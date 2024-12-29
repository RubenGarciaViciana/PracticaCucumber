package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductSteps {

	WebDriver driver;

	@Given("el usuari esta en la pagina principal 12")
	public void elUsuariEstaEnLaPaginaPrincipal12()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("^el usuari busca (.*)")
	public void elUsuariBusca(String producte)
	{
		 WebElement searchInput = driver.findElement(By.cssSelector("input[name='search']"));
	        
	        // Netejar la cerca
	        searchInput.clear();

	        // Buscar el producte
	        searchInput.sendKeys(producte);

	        // Fer click a buscar
	        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	}
	
	@Then("^el usuari veu (.*)")
	public void elUsuariVeu(String producte)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement productoElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/a[text()='" + producte + "']")));

	     String textoProducto = productoElemento.getText();
	     Assert.assertEquals(producte, textoProducto);
	}
	
	@Then("^el usuari no veu cap producte")
	public void elUsuariNoVeuCapProducte()
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> productos = driver.findElements(By.cssSelector(".product-thumb"));

        Assert.assertTrue(productos.isEmpty());
	}
	
	

}