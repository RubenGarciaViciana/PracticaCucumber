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

public class DetallProducteSteps {

	WebDriver driver;
	
	@Given("el usuari esta en la pagina principal 13")
	public void elUsuariEstaEnLaPaginaPrincipal13()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}

	@When("^el usuari fa click a un producte (.*)")
	public void elUsuariFaClickAUnProducte(String producte)
	{
		driver.findElement(By.partialLinkText(producte)).click();
	}
	
	@Then("^el detall de (.*) es mostra")
	public void elDetallDeProducteEsMostra(String producte) {
		WebElement enlace = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//ul[@class='breadcrumb']//a[contains(text(), '" + producte + "')]")));

	    String textoEnlace = enlace.getText();

	    Assert.assertTrue(textoEnlace.contains(producte));
	}
}
