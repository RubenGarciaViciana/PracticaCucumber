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

public class AfegirWishlistSteps {

WebDriver driver;
	
	@Given("el usuari esta en la pagina principal 4")
	public void elUsuariEstaEnLaPaginaPrincipal4()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("^el usuari fa click en Add to Wish List de (.*)")
	public void elUsuariFaClickEnAddToWishListDe(String producte)
	{
		WebElement productContainer = driver.findElement(By.xpath("//h4/a[text()='" + producte + "']/ancestor::div[contains(@class, 'product-thumb')]"));
		
		WebElement wishlistButton = productContainer.findElement(By.xpath(".//button[contains(@onclick, 'wishlist.add')]"));
		
	    wishlistButton.click();
	}
	
	@Then("^apareix el missatge de correctament afegit el (.*)")
	public void apareixElMissatgeDeCorrectamentAfegitEl(String producte)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement wishlistElement = wait.until(driver -> {
	        WebElement element = driver.findElement(By.id("wishlist-total"));
	        String title = element.getAttribute("title");
	        return title.contains("Wish List (1)") ? element : null;
	    });
	    
	    // Verificar si se ha añadido 
	    String texto = wishlistElement.getAttribute("title");
	    Assert.assertTrue(texto.contains("Wish List (1)"));
	}
}
