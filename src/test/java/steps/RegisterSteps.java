package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	WebDriver driver;
	
	//Registrarse
	
	@Given("el usuari esta en la pagina principal 1")
	public void elUsuariEstaEnLaPaginaPrincipal1()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("el usuari fa click en My Account")
	public void elUsuariFaClickEnMyAccount()
	{
		driver.findElement(By.cssSelector("[title='My Account']")).click();
	}
	
	@When("el usuari selecciona la opcio de Register")
	public void elUsuariSeleccionaLaOpcioDeRegister()
	{
		driver.findElement(By.partialLinkText("Register")).click();
	}
	
	@When("al usuari se li mostra la pantalla de Registre")
	public void alUsuariSeLiMostraLaPantallaDeRegistre()
	{
		String title = driver.findElement(By.cssSelector("#content h1")).getText();
		Assert.assertTrue(title.contains("Account"));
	}
	
	@When("^el usuari introdueix les dades correctament (.*), (.*), (.*), (.*)")
	public void elUsuariIntrodueixLesDadesCorrectament(String nom, String cognom, String email, String telefon)
	{
		driver.findElement(By.id("input-firstname")).sendKeys(nom);
		driver.findElement(By.id("input-lastname")).sendKeys(cognom);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(telefon);
		
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		
		
	}
	
	@When("el usuari marca el checkbox de Privacy Policy")
	public void elUsuariMarcaElCheckboxDePrivacyPolicy()
	{
		driver.findElement(By.name("agree")).click();
	}
	
	@When("el usuari li dona a continuar")
	public void elUsuariLiDonaAContinuar()
	{
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	}
	
	
	@Then("la pantalla de te has registrat correctament apareix")
	public void laPantallaDeTeHasRegistratCorrectamentApareix()
	{
	    WebElement contentElement = driver.findElement(By.id("content"));
	    
	    // Buscar el texto dentro del párrafo
	    String paragraphText = contentElement.findElement(By.tagName("p")).getText();
	    Assert.assertTrue(paragraphText.contains("Congratulations! Your new account has been successfully created!"));
	}
	
	//Deixar buits
	
	@Then("el errors del camps obligatoris apareixen")
	public void elErrorsDelCampsObligatorisApareixen()
	{
		String title = driver.findElement(By.cssSelector(".text-danger")).getText();
		Assert.assertTrue(title.contains("First Name must be between 1 and 32 characters!"));
	}
	
	//Contrasenyes no coincideixen
	@When("^el usuari introdueix les dades malament (.*), (.*), (.*), (.*)")
	public void elUsuariIntrodueixLesDadesMalament(String nom, String cognom, String email, String telefon)
	{
		driver.findElement(By.id("input-firstname")).sendKeys(nom);
		driver.findElement(By.id("input-lastname")).sendKeys(cognom);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(telefon);
		
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("4321");
			
	}
	
	@Then("el error del contrasenya apareix")
	public void elErrorDelContrasenyaApareix()
	{
		String title = driver.findElement(By.cssSelector(".text-danger")).getText();
		Assert.assertTrue(title.contains("Password confirmation does not match password!"));
	}
	
	//No acceptar politiques de privacitat
	
	@Then("el error de politiques de privacitat apareix")
	public void elErrorDePolitiquesDePrivacitatApareix()
	{
		 String message = driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
		 Assert.assertTrue(message.contains("Warning: You must agree to the Privacy Policy!"));
	}
}
