package steps;

import java.time.Duration;

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

public class VisualitzarCategoriesSteps {

	WebDriver driver;
	
	//Compartit
	@Given("el usuari esta en la pagina principal")
	public void elUsuariEstaEnLaPaginaPrincipal()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@Then("^la llista de la categoria (.*) apareix")
	public void laLlistaDeLaCategoriaApareix(String categoria)
	{
		String title = driver.findElement(By.tagName("h2")).getText();
		Assert.assertTrue(title.contains(categoria));
	}
	
	//Categoria de un grup
	
	@When("^el usuari fa click en el grup (.*)")
	public void elUsuariFaClickEnElGrup(String grup)
	{
		driver.findElement(By.partialLinkText(grup)).click();
	}
	
	@When("^el usuari selecciona la categoria (.*) del grup (.*)")
	public void elUsuariSeleccionaLaCategoriaDelGrup(String categoria, String grup)
	{
		driver.findElement(By.partialLinkText(categoria)).click();
	}
	
	//Categoria sense grup
	@When("^el usuari fa click en la categoria (.*)")
	public void elUsuariSeleccionaLaCategoriaDelGrup(String categoria)
	{
		driver.findElement(By.partialLinkText(categoria)).click();
	}
	
}
