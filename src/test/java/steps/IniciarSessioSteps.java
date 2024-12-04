package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IniciarSessioSteps {
	
	WebDriver driver;
	
	//Iniciar Sessio
	
	@Given("el usuari esta en la pagina principal 2")
	public void elUsuariEstaEnLaPaginaPrincipal2()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("el usuari fa click en My Account 1")
	public void elUsuariFaClickEnMyAccount1()
	{
		driver.findElement(By.cssSelector("[title='My Account']")).click();
	}
	
	@When("el usuari selecciona la opcio de Login")
	public void elUsuariSeleccionaLaOpcioDeLogin()
	{
		driver.findElement(By.partialLinkText("Login")).click();
	}
	
	@When("al usuari se li mostra la pantalla de Login")
	public void alUsuariSeLiMostraLaPantallaDeLogin()
	{
		String formAction = driver.findElement(By.cssSelector(".well form")).getAttribute("action");
	    Assert.assertTrue(formAction.contains("route=account/login"));
	}
	
	@When("^el usuari introdueix les dades de Login correctament (.*)")
	public void elUsuariIntrodueixLesDadesCorrectament(String email)
	{
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys("1234");
	}
	
	@When("el usuari li dona al boto de Login")
	public void elUsuariLiDonaAContinuar()
	{
		driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
	}
	
	@Then("la pantalla de My Account apareix")
	public void laPantallaDeMyAccountApareix()
	{
		String title = driver.findElement(By.cssSelector("#content h2")).getText();
		Assert.assertTrue(title.contains("My Account"));
	}
	
	// Correu invalid
	@When("^el usuari introdueix un correu invalid (.*)")
	public void elUsuariIntrodueixUnCorreuInvalid(String email)
	{
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys("1234");
	}
	
	@Then("el error del email apareix")
	public void elErrorDelEmailApareix()
	{
		String message = driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
		 Assert.assertTrue(message.contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	// Pasword invalid
	@When("^el usuari introdueix un contrasenya invalid (.*)")
	public void elUsuariIntrodueixUnContrasenyaInvalid(String email)
	{
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys("4321");
	}
	
	@Then("el error del contrasenya apareix 2")
	public void elErrorDelContrasenyaApareix2()
	{
		String message = driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
		 Assert.assertTrue(message.contains("Warning: No match for E-Mail Address and/or Password."));
	}
}
