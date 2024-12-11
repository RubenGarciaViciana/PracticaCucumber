package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisualitzarContactUsSteps {

	WebDriver driver;

	@Given("el usuari esta en la pagina principal 8")
	public void elUsuariEstaEnLaPaginaPrincipal8()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("^el usuari fa click en Contact us")
	public void elUsuariFaClickEnContactUs()
	{
		 WebElement contactUsLink = driver.findElement(By.xpath("//footer//a[text()='Contact Us']"));
	     contactUsLink.click();
	}
	
	 @Then("^el usuari es redirigit a la pagina de Contact us$")
	    public void elUsuariEsRedirigitALaPaginaDeContactUs()
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(driver -> driver.getTitle().contains("Contact Us"));

	        // Comprobar que estamos en la página de "Contact Us"
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertTrue(currentUrl.contains("route=information/contact"), 
	                "No se redirigió correctamente a la página de Contact Us.");
	    }
}