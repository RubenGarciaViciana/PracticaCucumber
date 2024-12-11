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

public class AfegirCarritoSteps {

	WebDriver driver;

	@Given("el usuari esta en la pagina principal 7")
	public void elUsuariEstaEnLaPaginaPrincipal7()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("^el usuari fa click en Add to Cart de (.*)")
	public void elUsuariFaClickEnAddToCarttDe(String producte)
	{
		WebElement productContainer = driver.findElement(By.xpath("//h4/a[text()='" + producte + "']/ancestor::div[contains(@class, 'product-thumb')]"));
		
		WebElement addToCartButton = productContainer.findElement(By.xpath(".//button[contains(@onclick, 'cart.add')]"));
		
		addToCartButton.click();
	}
	
	@Then("^apareix el missatge de correctament afegit al (.*)")
	public void apareixElMissatgeDeCorrectamentAfegitAl(String producte)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement wishlistElement = wait.until(driver -> {
	        WebElement element = driver.findElement(By.id("cart-total"));
	        String title = element.getText();
	        return title.contains("1 item(s)") ? element : null;
	    });
	    
	 
	    String texto = wishlistElement.getText();
	    Assert.assertTrue(texto.contains("1 item(s)"));
	}
}