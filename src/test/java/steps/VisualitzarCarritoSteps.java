package steps;

import static org.testng.Assert.assertEquals;

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

public class VisualitzarCarritoSteps {

	WebDriver driver;

	@Given("el usuari esta en la pagina principal 15")
	public void elUsuariEstaEnLaPaginaPrincipal15()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("el usuari afegeix un producte al carrito")
	public void elUsuariAfegeixUnProducteAlCarrito()
	{
		WebElement productContainer = driver.findElement(By.xpath("//h4/a[text()='MacBook']/ancestor::div[contains(@class, 'product-thumb')]"));
		
		WebElement addToCartButton = productContainer.findElement(By.xpath(".//button[contains(@onclick, 'cart.add')]"));
		
		addToCartButton.click();
	}
	
	
	@When("el usuari dona click al boto de carrito")
	public void elUsuariDonaClickAlBotoDeCarrito()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		 WebElement cartButton = wait.until(driver -> 
	        driver.findElement(By.xpath("//a[@title='Shopping Cart']"))
	    );
	    
	    cartButton.click();
	}
	
	@Then("apareix el carrito")
	public void apareixElCarrito() {
		WebElement table = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='table-responsive']/table")));

	    WebElement productCell = table.findElement(By.xpath(".//tbody/tr/td/a[text()='MacBook']"));

	    String productText = productCell.getText();
	    
	    Assert.assertTrue(productText.contains("MacBook"), "El producto no está en la tabla.");
	}
	
	@Then("el carrito esta buit")
	public void elCarritoEstaBuit()
	{
		 WebElement mensajeCarritoVacio = new WebDriverWait(driver, Duration.ofSeconds(10))
		            .until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//div[@id='content']/p[contains(text(), 'Your shopping cart is empty!')]")));

		    String mensaje = mensajeCarritoVacio.getText();
		    Assert.assertEquals(mensaje, "Your shopping cart is empty!");
	}
}