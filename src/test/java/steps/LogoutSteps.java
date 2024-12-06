package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {

	WebDriver driver;
	
	@Given("el usuari esta en la pagina principal 3")
	public void elUsuariEstaEnLaPaginaPrincipal3()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("el usuari fa el proces de Login")
	public void elUsuariFaElProcesDeLogin()
	{
		// Va a la pantalla
		driver.findElement(By.cssSelector("[title='My Account']")).click();
		driver.findElement(By.partialLinkText("Login")).click();
		
		//Introdueix les dades
		driver.findElement(By.id("input-email")).sendKeys("ruben.garcia@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		
		// Li dona click a Login
		driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
	}
	
	@When("el usuari fa click en la seccio de Logout")
	public void elUsuariFaClickEnLaSeccioDeLogout()
	{
		driver.findElement(By.partialLinkText("Logout")).click();
	}
	
	@When("es mostra la pantalla per fer Logout")
	public void esMostraLaPantallaPerFerLogout()
	{
		WebElement contentElement = driver.findElement(By.id("content"));
	    
	    // Buscar el texto dentro del párrafo
	    String paragraphText = contentElement.findElement(By.tagName("p")).getText();
	    Assert.assertTrue(paragraphText.contains("You have been logged off your account. It is now safe to leave the computer."));
	}
	
	@When("el usuari fa click al boto de Continue")
	public void elUsuariFaClickAlBotoDeContinue()
	{
		driver.findElement(By.linkText("Continue")).click();
	}
	
	@Then("la pantalla principal apareix")
	public void laPantallaPrincipalApareix()
	{
		String titol = driver.findElement(By.linkText("Your Store")).getText();
		Assert.assertTrue(titol.contains("Your Store"));
		
	}
}
