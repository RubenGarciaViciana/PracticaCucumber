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

public class VisualitzarPerfilSteps {

	WebDriver driver;

	@Given("el usuari esta en la pagina principal 10")
	public void elUsuariEstaEnLaPaginaPrincipal10()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("el usuari fa el proces de Login 2")
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
	
    @When("el usuari torna a la pantalla principal")
    public void elUsuariTornaALaPantallPrincipal() {
    	driver.findElement(By.cssSelector("#logo h1 a")).click();
    }
    
    @When("obra MyAccount")
    public void obraMyAccount() {
    	driver.findElement(By.cssSelector("[title='My Account']")).click();
    }
    
    @When("fa click a MyAccount")
    public void faClickAMyAccount() {
    	driver.findElement(By.xpath("//li/a[text()='My Account']")).click();
    }
   
    @Then("el usuari es redirigit a la pagina de account")
    public void elUsuariEsRedirigitAPaginaDeAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("account"));
        
        Assert.assertTrue(driver.getCurrentUrl().contains("account"), "El usuario no fue redirigido a la página de cuenta.");
        
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("My Account"), "El título de la página no es el esperado.");
    }
}
